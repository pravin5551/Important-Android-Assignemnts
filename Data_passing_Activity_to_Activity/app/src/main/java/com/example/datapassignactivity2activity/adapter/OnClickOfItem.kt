package com.example.datapassignactivity2activity.adapter

import com.example.datapassignactivity2activity.newModel.ResponseItem


interface OnClickOfItem {

    fun showDetails(responseItem: ResponseItem, position:Int)
}