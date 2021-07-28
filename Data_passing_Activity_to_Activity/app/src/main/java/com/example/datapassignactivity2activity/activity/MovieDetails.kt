package com.example.datapassignactivity2activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.datapassignactivity2activity.R

import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setData()
    }


    private fun setData() {
        tvName.text=intent.getStringExtra("name")
        val image=intent.getStringExtra("photo")
        Glide.with(ivMovie).load(image).into(ivMovie)
        tvRating.text=intent.getStringExtra("premiered")
        tvtype.text=intent.getStringExtra("language")
        tvSummary.text=intent.getStringExtra("summary")
    }
}