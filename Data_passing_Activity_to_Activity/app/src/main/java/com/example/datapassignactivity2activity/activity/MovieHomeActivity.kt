package com.example.datapassignactivity2activity.activity


import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datapassignactivity2activity.R
import com.example.datapassignactivity2activity.adapter.BottomAdapter
import com.example.datapassignactivity2activity.adapter.OnClickOfItem
import com.example.datapassignactivity2activity.adapter.TopAdapter
import com.example.datapassignactivity2activity.newModel.ResponseItem
import com.example.datapassignactivity2activity.repository.MovieRepository
import com.example.datapassignactivity2activity.viewmodel.MovieViewModel
import com.example.datapassignactivity2activity.viewmodel.ViewModelFactory

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*


class MovieHomeActivity : AppCompatActivity() , OnClickOfItem {
    private lateinit var listViewModel: MovieViewModel
    private lateinit var listAdapter: BottomAdapter
    private lateinit var layoutManagers: LinearLayoutManager
    private lateinit var listAdapterTop: TopAdapter
    var dataModelList = mutableListOf<ResponseItem>()
    var num:Int=2

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository by lazy {
            MovieRepository()
        }
        // ViewModelFactory for getting the repository instance
        val factory = ViewModelFactory(repository)
        listViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)


        checkNetwork()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun checkNetwork() {
        if (isNetworkConnected()) {
            observerData()
            setRecyclerAdapter()
            showPageNation()
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Opps...")
            builder.setMessage("Please check your Internet connection")
            builder.setPositiveButton("Ok!", null)
            val alert: AlertDialog = builder.create()
            alert.show()
        }
    }

    /*
    showPageNation is use for getting list infinity scroll effect
     */

    private fun showPageNation() {

        var loading = true
        var pastVisiblesItems: Int
        var visibleItemCount: Int
        var totalItemCount: Int

        recyclerViewBottom.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = layoutManagers.getChildCount()
                    totalItemCount = layoutManagers.getItemCount()
                    pastVisiblesItems = layoutManagers.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false
                            Log.v("...", "Last Item Wow !")
                            num++
                                getData()


                            loading = true
                        }
                    }
                }
            }
        })
    }

    private fun getData() {
        listViewModel.movieLiveData(num).observe(this, Observer {
            dataModelList.addAll(it)
            listAdapter.notifyDataSetChanged()
        })
    }

    /*
    observerData is observing the live data from the view model and setting the response to the recyclerview
     */

    private fun observerData() {
        listViewModel.movieLiveData(num).observe(this, Observer {
            dataModelList.clear()
            dataModelList.addAll(it)
            listAdapter.notifyDataSetChanged()
            listAdapterTop.notifyDataSetChanged()

        })
    }
        /*
        setRecyclerAdapter is setting the Adapter and LayoutManagers
         */
    private fun setRecyclerAdapter() {
        listAdapter = BottomAdapter(dataModelList,this)
        layoutManagers = GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)
        recyclerViewBottom.apply {
            this.layoutManager = layoutManagers
            adapter = listAdapter
        }

        listAdapterTop= TopAdapter(dataModelList,this)
        recyclerViewTop.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewTop.adapter=listAdapterTop
    }
        /**
            showDetails is override function of interface onclick , and using this interface im calling the Movie
            Details Activity and sending the data form
         */
    override fun showDetails(responseItem: ResponseItem, position: Int) {

        val intent= Intent(this,MovieDetails::class.java)
        intent.putExtra("photo",responseItem.image.medium)
        intent.putExtra("name",responseItem.name)
        intent.putExtra("premiered",responseItem.premiered)
        intent.putExtra("language",responseItem.language)
        intent.putExtra("summary",responseItem.summary)
        startActivity(intent)
    }


    /*
    IsNetworkConnected checks the internet connection available or not
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun isNetworkConnected(): Boolean {
        //1
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        //2
        val activeNetwork = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.activeNetwork
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        //3
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        //4
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

}

