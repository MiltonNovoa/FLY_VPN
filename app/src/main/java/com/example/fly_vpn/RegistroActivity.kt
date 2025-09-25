package com.example.fly_vpn

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editNombres: EditText
    private lateinit var editApellidos: EditText
    private lateinit var editCorreo: EditText
    private lateinit var editTelefono: EditText
    private lateinit var editContrasena: EditText
    private lateinit var editRepetirContrasena: EditText
    private lateinit var checkTerms: CheckBox
    private lateinit var btnGoLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        // Inicializar vistas
        editNombres = findViewById(R.id.editNombres)
        editApellidos = findViewById(R.id.editApellidos)
        editCorreo = findViewById(R.id.editCorreo)
        editTelefono = findViewById(R.id.editTelefono)
        editContrasena = findViewById(R.id.editContrasena)
        editRepetirContrasena = findViewById(R.id.editRepetirContrasena)
        checkTerms = findViewById(R.id.checkTerminos)
        btnGoLogin = findViewById(R.id.btnRegistrar)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        setupOnClickListener()
    }

    private fun setupOnClickListener() {
        btnGoLogin.setOnClickListener {
            val names = editNombres.text.toString().trim()
            val lastnames = editApellidos.text.toString().trim()
            val email = editCorreo.text.toString().trim()
            val phone = editTelefono.text.toString().trim()
            val password = editContrasena.text.toString().trim()
            val password2 = editRepetirContrasena.text.toString().trim()

            if (validateFields(names, lastnames, email, phone, password, password2)) {
                saveUserData(names, lastnames, email, phone, password)

                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun validateFields(names: String, lastnames: String,email: String, phone : String, password: String, password2: String): Boolean {
        if (names.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su nombre", Toast.LENGTH_SHORT).show()
            return false
        }
        if (lastnames.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su apellido", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Por favor ingrese un email válido", Toast.LENGTH_SHORT).show()
            return false
        }
        if(phone.isEmpty()){
            Toast.makeText(this, "Por favor ingrese su teléfono", Toast.LENGTH_SHORT).show()
            return false

        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password2.isEmpty()) {
            Toast.makeText(this, "Por favor confirme su contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password != password2) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!checkTerms.isChecked) {
            Toast.makeText(
                this,
                "Por favor acepte los términos y condiciones",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }

    private fun saveUserData(name: String, lastName: String, email: String, phone: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("lastName", lastName)
        editor.putString("email", email)
        editor.putString("phone", phone)
        editor.putString("password", password)

        editor.apply()
    }
}