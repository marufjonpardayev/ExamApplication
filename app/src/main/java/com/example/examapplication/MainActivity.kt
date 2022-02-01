package com.example.examapplication

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examapplication.adapter.RecyclerAdapter
import com.example.examapplication.listener.OnBottomReachedListener
import com.example.examapplication.model.Food
import java.util.*

class MainActivity : AppCompatActivity() {
    var context: Context? = null
    var recyclerView: RecyclerView? = null
    private var foodsSum: ArrayList<Food> = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context=this
        initViews()
        foodsSum+=prepareFoodList()
        refreshAdapter(foodsSum)

    }



   private fun initViews() {
       recyclerView = findViewById(R.id.recycler)
       val orientation = resources.configuration.orientation
       if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
           recyclerView!!.layoutManager= GridLayoutManager(context, 3)

       } else {
           recyclerView!!.layoutManager= GridLayoutManager(context, 1)
       }
       context = this

    }
    private fun prepareFoodList():ArrayList<Food>{
        for (i in 0..5){
            foodsSum.add(Food(R.drawable.food1, "Diner Steakhouse",4f))
            foodsSum.add(Food(R.drawable.food2, "Fire Hyper",5f))
            foodsSum.add(Food(R.drawable.food3, "Google restaurant",4.5f))
            foodsSum.add(Food(R.drawable.food4, "Fast Food",3.5f))
            foodsSum.add(Food(R.drawable.food5, "Lavash centre",4f))
        }
        return foodsSum
    }


   private fun refreshAdapter(foods: ArrayList<Food>) {
        val adapter = RecyclerAdapter(context!!, foods,object :OnBottomReachedListener{
            override fun onBottomReached(position: Int) {
                prepareFoodList()
            }

        })
        recyclerView!!.adapter = adapter
    }


}