package com.example.datapassignactivity2activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datapassignactivity2activity.R
import com.example.datapassignactivity2activity.newModel.ResponseItem
import kotlinx.android.synthetic.main.top_item.view.*

class TopAdapter (private var dataList: List<ResponseItem>, var onClickOfItem: OnClickOfItem
) : RecyclerView.Adapter<TopAdapter.TopViewHolder>() {

    class TopViewHolder(itemView: View,var onClickOfItem: OnClickOfItem) : RecyclerView.ViewHolder(itemView) {
        fun setData(responseItem: ResponseItem) {
            Glide.with(itemView.ivTop).load(responseItem.image.medium).error(R.drawable.ic_launcher_foreground)
                .into(itemView.ivTop)
            itemView.ivTop.setOnClickListener {
                onClickOfItem.showDetails(responseItem,bindingAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_item, parent, false)
        return TopViewHolder(view,onClickOfItem)
    }

    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
        holder.setData(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}