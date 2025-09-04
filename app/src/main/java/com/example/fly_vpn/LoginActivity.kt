package com.example.fly_vpn

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextUser: TextView = findViewById(R.id.editTextUser)
        val Password: TextView = findViewById(R.id.Password)
        val boton_ingresar: TextView = findViewById(R.id.boton_ingresar)

        boton_ingresar.setOnClickListener {
            val intent = Intent(this, boton_ingresar::class.java)
            startActivity(intent)
        }

        editTextUser.setOnClickListener {
            val intent = Intent(this, editTextUser::class.java)
            startActivity(intent)
        }

        Password.setOnClickListener {
            val intent = Intent(this, Password::class.java)
            startActivity(intent)
        }
    }
}