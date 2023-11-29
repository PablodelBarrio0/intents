package com.example.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SaludoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo)
        val fullName = intent.getStringExtra(FULL_NAME_KEY)
        val textSaludo: TextView = findViewById(R.id.textViewSaludo)
        textSaludo.text = getString(R.string.saludoTexto, fullName)
    }
}