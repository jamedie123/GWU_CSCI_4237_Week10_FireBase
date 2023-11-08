package com.example.loginappinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView=findViewById(R.id.recyclerView)

        val location:String = intent.getStringExtra("location").toString()
        Log.d("MainActivity2", "Location is $location")
        title = location

        val yelps = getFakeYelpData()
        val adapter=YelpAdapter(yelps)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)
    }
    private fun getFakeYelpData(): List<YelpBusiness>{
        return listOf(
            YelpBusiness("Panera", "Breakfast", 4.2, "https://..."),
            YelpBusiness("WingsToGo", "Comfort", 5.3 , "https://..."),
            YelpBusiness("Log Cabin", "Seafood", 4.2, "https://..."),
            YelpBusiness("Dunkin Donut", "Breakfast", 3.1, "https://..."),
            YelpBusiness("Starbucks", "Coffee", 3.1, "https://..."),
            YelpBusiness("Panera", "Breakfast", 3.1, "https://..."),
            YelpBusiness("Panera", "Breakfast", 3.1 , "https://..."),
            YelpBusiness("Panera", "Breakfast", 2.8 , "https://..."),
            YelpBusiness("Panera", "Breakfast", 5.3 , "https://..."),
            YelpBusiness(icon="https://...", category = "Dinner", rating = 1.2 , restaurantName="Subway")
        )
    }
}