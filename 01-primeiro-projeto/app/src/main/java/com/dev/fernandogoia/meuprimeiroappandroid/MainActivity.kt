package com.dev.fernandogoia.meuprimeiroappandroid

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dev.fernandogoia.meuprimeiroappandroid.broadcastreceiver.LowBatterBroadcastReceiver
import com.dev.fernandogoia.meuprimeiroappandroid.databinding.ActivityMainBinding
import com.dev.fernandogoia.meuprimeiroappandroid.service.SyncDataService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val lowBatterBroadcastReceiver = LowBatterBroadcastReceiver()
    private val lowBatterIntentFilter = IntentFilter("android.intent.action.BATTERY_LOW")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Toast.makeText(this, "Meu primeiro Toast", Toast.LENGTH_SHORT).show()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding.tvHelloWorld) {
            text = context.getString(R.string.test)
            textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        }

        supportFragmentManager.beginTransaction().add(
            R.id.flMainContainer, BlankFragment.newInstance(
                name = "Hello Kotlin", age = 100, isMale = true
            )
        ).commit()

        registerReceiver(lowBatterBroadcastReceiver, lowBatterIntentFilter)

        val intent = Intent(this, SyncDataService::class.java)
        startService(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(lowBatterBroadcastReceiver)
    }
}