package com.example.audio

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var button3:Button
    lateinit var button4:Button
    lateinit var button5:Button
    lateinit var button6:Button
    lateinit var mp : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)

        button3.setOnClickListener{
            mp=MediaPlayer.create(this,R.raw.mahi)
            mp.start()
        }
        button4.setOnClickListener {
            mp.stop()
        }
        button5.setOnClickListener {
            mp= MediaPlayer()

            mp.setDataSource(this,Uri.parse("https://www.pagalworld.com.sb/o-mahi-o-mahi-mp3-song-download.html"))
            mp.prepare()
            mp.start()
        }
        button6.setOnClickListener {
            mp.stop()
        }
    }

}