package com.example.fly_vpn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Usamos corutinas para esperar 3 segundos
        lifecycleScope.launch {
            delay(3000) // 3 segundos
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}
