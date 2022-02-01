package com.example.examapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examapplication.R
import com.example.examapplication.listener.OnBottomReachedListener
import com.example.examapplication.model.Food
import java.util.*


class RecyclerAdapter(var context: Context, members: ArrayList<Food>,var listener: OnBottomReachedListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var foods: ArrayList<Food> = members
    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout, parent, false)
        return MemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == foods.size - 1) {
            with(listener) { onBottomReached(position) }
        }
        val food: Food = foods[position]
        if (holder is MemberViewHolder) {
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname
            val ratingBar=holder.rating
            iv_profile.setImageResource(food.profile)
            tv_fullname.text = food.fullName
            ratingBar.rating=food.rating
        }
    }

    class MemberViewHolder(var view: View) : RecyclerView.ViewHolder(
        view
    ) {
        var iv_profile: ImageView = view.findViewById(R.id.imageView1)
        var tv_fullname: TextView = view.findViewById(R.id.tvName)
        var rating:RatingBar=view.findViewById(R.id.ratingBar)

    }

}