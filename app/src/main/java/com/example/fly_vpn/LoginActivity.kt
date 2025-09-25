package com.example.fly_vpn

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextUser: TextView = findViewById(R.id.editTextUser)
        val Password: TextView = findViewById(R.id.Password)
        val boton_ingresar: TextView = findViewById(R.id.boton_ingresar)
        val etEmail: EditText = findViewById(R.id.editTextUser)
        val etPassword: EditText = findViewById(R.id.Password)
        boton_ingresar.setOnClickListener {
            comparacionLogin(etEmail, etPassword)
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

    private fun comparacionLogin(etEmail: String, etPassword: String) {
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("email", "")
        val savedPassword = sharedPreferences.getString("password", "")
        if (email == savedEmail && password == savedPassword) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
        }
    }
}