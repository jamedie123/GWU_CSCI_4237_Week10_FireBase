package com.example.loginappinclass

//import YelpAdapter
import YelpAdapter
import android.location.Address
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var myYelpText: EditText
    private lateinit var addNewYelpBtn: FloatingActionButton
    private lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView=findViewById(R.id.recyclerView)
        myYelpText = findViewById(R.id.yelpText)
        addNewYelpBtn = findViewById(R.id.floatingActionButton)
        firebaseDatabase=FirebaseDatabase.getInstance()

//        val location:String = intent.getStringExtra("location").toString()
        Log.d("MainActivity2", "Location is nnnn")
//        Log.d("MainActivity2", "Location is $location")
//        title = location
//        setTitle(location)

        val address = if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("address", Address::class.java)!!
        }else {
            intent.getParcelableExtra<Address>("address")!!
        }
/*     val yelpManager = YelpManager()
        val gwuLat = address.latitude
        val gwuLong = address.longitude
        setTitle(address.adminArea)
        val apiKey = getString(R.string.yel_api_key)
        var yelps = listOf<YelpBusiness>()

        //Coroutines
        CoroutineScope(IO).launch {
            yelps = yelpManager.retrieveYelps(gwuLat,gwuLong,apiKey)
        }

        withContext(Main){
            val adapter = YelpAdapter(yelps)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity2)
        }
}
        val yelps = getFakeYelpData()
        val adapter=YelpAdapter(yelps)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)


    private fun getFakeYelpData(): List<YelpBusiness>{
        return listOf(
//            YelpBusiness("Panera", "Breakfast", "4 star", "https://..."),
//            YelpBusiness("WingsToGo", "Comfort", "5 star" , "https://..."),
//            YelpBusiness("Log Cabin", "Seafood", "4 star", "https://..."),
//            YelpBusiness("Dunkin Donut", "Breakfast", "3 star", "https://..."),
//            YelpBusiness("Starbucks", "Coffee", "3 star", "https://..."),
//            YelpBusiness("Panera", "Breakfast", "3 star", "https://..."),
//            YelpBusiness("Panera", "Breakfast", "3 star" , "https://..."),
//            YelpBusiness("Panera", "Breakfast", "2 star" , "https://..."),
//            YelpBusiness("Panera", "Breakfast", "5 star", "https://..."),
////            YelpBusiness("Subway","Dinner",1.2,"https://...")
//            YelpBusiness("Subway","Dinner","1.2","https://...")
        )
    }
    */
    }
}
