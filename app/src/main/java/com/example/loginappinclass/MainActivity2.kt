package com.example.loginappinclass

//import YelpAdapter
import YelpAdapter
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
//        title = location
        setTitle(location)

        val yelps = getFakeYelpData()
        val adapter=YelpAdapter(yelps)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)

    }

    private fun getFakeYelpData(): List<YelpBusiness>{
        return listOf(
            YelpBusiness("Panera", "Breakfast", "4 star", "https://..."),
            YelpBusiness("WingsToGo", "Comfort", "5 star" , "https://..."),
            YelpBusiness("Log Cabin", "Seafood", "4 star", "https://..."),
            YelpBusiness("Dunkin Donut", "Breakfast", "3 star", "https://..."),
            YelpBusiness("Starbucks", "Coffee", "3 star", "https://..."),
            YelpBusiness("Panera", "Breakfast", "3 star", "https://..."),
            YelpBusiness("Panera", "Breakfast", "3 star" , "https://..."),
            YelpBusiness("Panera", "Breakfast", "2 star" , "https://..."),
            YelpBusiness("Panera", "Breakfast", "5 star", "https://..."),
//            YelpBusiness("Subway","Dinner",1.2,"https://...")
            YelpBusiness("Subway","Dinner","1.2","https://...")
        )
    }
}