package com.example.loginappinclass

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class YelpAdapter(val yelps: List<YelpBusiness>): RecyclerView.Adapter<YelpAdapter.ViewHolder>() {
    class ViewHolder(rootLayout: View): RecyclerView.ViewHolder(rootLayout) {
        val restaurantText: TextView=rootLayout.findViewById(R.id.restaurant_name)
        val categoryText: TextView=rootLayout.findViewById(R.id.Category)
        val rating: TextView=rootLayout.findViewById(R.id.rating)
        val icon: ImageView=rootLayout.findViewById(R.id.icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //create a new viewHolder
        //need to read the xml row
        Log.d("RV", "inside onCreateViewHolder")
        val layoutInflater: LayoutInflater= LayoutInflater.from(parent.context)
        val rootLayout: View=layoutInflater.inflate(R.layout.cardviewlayout, parent, false)
        val viewHolder=ViewHolder(rootLayout)
        return viewHolder
    }

    override fun getItemCount(): Int {
        Log.d("RV", "inside getItemCount")
        return yelps.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentYelp=yelps[position]
        holder.restaurantText.text= currentYelp.restaurantName
        holder.categoryText.text= currentYelp.category
        holder.rating.text=currentYelp.rating
        Log.d("RV", "inside onBindViewHolder on position $position")
        //holder.icon later
    }
}