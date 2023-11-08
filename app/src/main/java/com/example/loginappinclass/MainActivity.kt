package com.example.loginappinclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.google.android.gms.maps.MapsInitializer

class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginBtn: Button
    private lateinit var progressbar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Log.d("MainActivity","onCreate() called")

        username = findViewById(R.id.usernameTxt)
        password = findViewById(R.id.passwordTxt)
        loginBtn = findViewById(R.id.loginBtn)
        progressbar = findViewById(R.id.progressBar)

        val sharedPrefs=getSharedPreferences("savedStuff", MODE_PRIVATE)

        loginBtn.isEnabled=false
        loginBtn.setOnClickListener{
            progressbar.visibility = View.VISIBLE

            val inputtedUsername: String=username.text.toString()
            sharedPrefs
                .edit()
                .putString("USERNAME", inputtedUsername)
                .apply()

            val intent = Intent(this, MapsActivity::class.java)
//            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("location", "Richmond")
            startActivity(intent)
        }

        username.addTextChangedListener(textWatcher)
        password.addTextChangedListener(textWatcher)

        val savedUserName = sharedPrefs.getString("USERNAME","" )
        username.setText(savedUserName)
    }
    private val textWatcher: TextWatcher=object:TextWatcher{
        override fun beforeTextChanged(s: CharSequence?,  start: Int, count: Int, after: Int) {
            Log.d("MainActivity", "before text changed")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int){
            Log.d("MainActivity", "in onTextChanged")
            val inputtedUsername: String=username.text.toString()
            val inputtedPassword: String=password.text.toString()
            val enableButton:Boolean=inputtedUsername.isNotBlank()
            loginBtn.setEnabled(enableButton)
        }

        override fun afterTextChanged(s: Editable?){
            Log.d("MainActivity", "In after Text changed")
        }
    }
}