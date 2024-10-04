package com.example.locationgeocode

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    lateinit var ed : EditText
    lateinit var bu : Button
    lateinit var tv2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed=findViewById(R.id.editTextTextPersonName)
        bu=findViewById(R.id.button)
        tv2=findViewById(R.id.textView)

        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),111)
        }
        else{
            bu.setOnClickListener {
                var city = ed.text.toString()
                forwardGeoLocation(city)
            }
        }



        }

    private fun forwardGeoLocation(city:String){
        var gc = Geocoder()
    }
}