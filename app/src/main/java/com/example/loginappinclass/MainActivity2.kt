package com.example.loginappinclass

//import YelpAdapter
import YelpAdapter
import android.location.Address
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.android.gms.maps.MapsInitializer
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
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
        //val yelps = getFakeYelpData()

        val state = address.adminArea?: "unknown"

        val reference = firebaseDatabase.getReference("Yelps/$state")
        addNewYelpBtn.setOnClickListener {
            val restaurantName = myYelpText.text.toString()
            val email = FirebaseAuth.getInstance().currentUser!!.email!!
            val yelp = YelpBusiness(
                restaurantName = restaurantName,
                category = email,
                url = "http...",
                rating = 5.0,
                icon = "..."
            )

            reference.push().setValue(yelp)
        }
            //read in changes to database
            reference.addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val yelps = mutableListOf<YelpBusiness>()
                    snapshot.children.forEach { childSnapshot: DataSnapshot ->
                        val yelp: YelpBusiness? = childSnapshot.getValue(YelpBusiness::class.java)
                        if (yelp!=null){
                            yelps.add(yelp)
                        }
                    }
                    val adapter = YelpAdapter(yelps)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity2)
                }

                override fun onCancelled(error: DatabaseError) {
                   Toast.makeText(this@MainActivity2, "failed to connect to db", Toast.LENGTH_LONG).show()
                    Log.e("YelpFirebase", "DB connect issue", error.toException())
                }
            }


            )


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
