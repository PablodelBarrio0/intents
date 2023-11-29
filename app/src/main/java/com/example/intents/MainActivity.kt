package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText


const val FULL_NAME_KEY = "full_name"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton: Button = findViewById(R.id.btnGuardar)
        boton.setOnClickListener {
            //Intent explícito para ir a nuestra SaludoActivity
            val editNombre: TextInputEditText = findViewById(R.id.txtNombre)
            val saludoIntent = Intent(this, SaludoActivity::class.java)
            saludoIntent.putExtra(FULL_NAME_KEY, editNombre.text.toString())
            startActivity(saludoIntent)
        }

        val botonEnviar = findViewById<Button>(R.id.btnEnviar)
        botonEnviar.setOnClickListener {
        // Ejemplo de intent implícito
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Hola mundo")
                type = "text/plain"
            }
            // Verificamos que haya actividades cantidatas para atenderlo
            if (sendIntent.resolveActivity(packageManager) != null) {
                //Lanzamos el intent
                startActivity(sendIntent)
            }
        }
    }

}