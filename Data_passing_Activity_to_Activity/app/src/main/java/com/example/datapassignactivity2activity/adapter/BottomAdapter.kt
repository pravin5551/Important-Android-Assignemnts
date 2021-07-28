package com.example.datapassignactivity2activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datapassignactivity2activity.R
import com.example.datapassignactivity2activity.newModel.ResponseItem
import kotlinx.android.synthetic.main.bottom_item.view.*

class BottomAdapter(
    private var dataList: List<ResponseItem>, var onClickOfItem: OnClickOfItem
) : RecyclerView.Adapter<BottomAdapter.BottomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bottom_item, parent, false)
        return BottomViewHolder(view,onClickOfItem)
    }

    override fun onBindViewHolder(holder: BottomViewHolder, position: Int) {
        holder.setData(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class BottomViewHolder(itemView: View,var onClickOfItem: OnClickOfItem) : RecyclerView.ViewHolder(itemView) {
        fun setData(responseItem:  ResponseItem) {
            Glide.with(itemView.ivBottomItem).load(responseItem.image.medium)
                .into(itemView.ivBottomItem)

            itemView.ivBottomItem.setOnClickListener {
                onClickOfItem.showDetails(responseItem,bindingAdapterPosition)
            }
        }
    }
}