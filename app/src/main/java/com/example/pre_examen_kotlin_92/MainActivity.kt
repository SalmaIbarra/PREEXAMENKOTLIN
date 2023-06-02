package com.example.pre_examen_kotlin_92

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button
    private lateinit var txtNombre: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        iniciarComponentes()
        btnIngresar.setOnClickListener {
            btnIngresar()
        }

        btnSalir.setOnClickListener {
            btnSalir()
        }
    }


    private fun iniciarComponentes() {
        btnIngresar = findViewById(R.id.btnEntrar)
        btnSalir = findViewById(R.id.btnSalir)
        txtNombre = findViewById(R.id.txtNombre)
    }

    private fun btnIngresar() {
        val strUsuario: String = resources.getString(R.string.nombre)

        if (strUsuario == txtNombre.text.toString()) {
            val intent = Intent(this@MainActivity, Recibo_Activity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(applicationContext, "El Usuario es incorrecto o el campo está vacío", Toast.LENGTH_SHORT).show()
        }
    }

    private fun btnSalir() {
        val confirmar = AlertDialog.Builder(this)

        confirmar.setTitle("Recibo Nomina")
        confirmar.setMessage("¿Desea Salir?")
        confirmar.setPositiveButton("Confirmar") { dialog, which ->
            finish()
        }
        confirmar.setNegativeButton("Cancelar") { dialog, which ->
            // No hacer nada
        }

        confirmar.show()
    }
}