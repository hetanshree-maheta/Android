package com.example.activity

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    lateinit var phone : EditText
    lateinit var smsBody : EditText
    lateinit var sendBu : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phone = findViewById(R.id.phone)
        smsBody = findViewById(R.id.smsBody)
        sendBu = findViewById(R.id.sendBu)

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_SMS
            ) != PackageManager.PERMISSION_DENIED
        ) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.RECEIVE_SMS,
                    android.Manifest.permission.SEND_SMS
                ),
                111
            )
        } else {
            receiveSMS()
        }
        sendBu.setOnClickListener {
            var sms = SmsManager.getDefault()
            sms.sendDataMessage(phone.text.toString(), "ME", smsBody.text.toString(), null, null)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if (requestCode==111 && grantResults[0]==PackageManager.PERMISSION_DENIED) {
                reciveSMS()
            }
       }

    private fun receiveSMS(){
        var br = object : BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
                    for (sms in Telephony.Sms.Intents.getMessagesFromIntent())
                }
            }
    }





    }
}