package com.example.videoview

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.VideoView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    lateinit var btn : Button
    lateinit var v1 : VideoView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btn = findViewById(R.id.btn)
        v1 = findViewById(R.id.video)

        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),222)
        }else{

            btn.isEnabled = true
        }
        btn.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            startActivityForResult(intent,101)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==101){
            v1.setVideoURI(data?.data)
            v1.start()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode==222 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            btn.isEnabled=true
        }
    }

}