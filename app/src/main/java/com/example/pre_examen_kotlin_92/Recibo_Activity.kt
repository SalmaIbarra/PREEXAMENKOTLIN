package com.example.pre_examen_kotlin_92

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.text.DecimalFormat

class Recibo_Activity : AppCompatActivity() {
    private lateinit var btnGenerar: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button

    private lateinit var lblUsuario: TextView

    private lateinit var txtNombre: EditText
    private lateinit var txtNumeroRecibo: EditText
    private lateinit var txtHorasTrabajadas: EditText
    private lateinit var txtHorasExtras: EditText

    private lateinit var rbAuxiliar: RadioButton
    private lateinit var rbAlbañil: RadioButton
    private lateinit var rbIngObra: RadioButton

    private lateinit var txtSubtotal: EditText
    private lateinit var txtImpuesto: EditText
    private lateinit var txtTotalPagar: EditText
    private val decimalFormat = DecimalFormat("#.##")

    private val reciboNomina = ReciboNomina(0, "", 0.0, 0.0, 0, 0.0)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibo)
        iniciarComponentes()

        val strUsuario = getString(R.string.nombre)
        lblUsuario.text = strUsuario

        btnGenerar.setOnClickListener {
            if(txtNumeroRecibo.text.toString().equals("") || txtNombre.text.toString().equals("") || txtHorasTrabajadas.text.toString().equals("") || txtHorasExtras.text.toString().equals("") )
            {
                Toast.makeText(applicationContext, "No deje campos vacios", Toast.LENGTH_SHORT).show()
            }
            else
            {
                btnGenerar()

            }

        }

        btnLimpiar.setOnClickListener {
            btnLimpiar()
        }
        btnRegresar.setOnClickListener {
            btnRegresar()
        }





    }

    private fun iniciarComponentes() {
        btnGenerar = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)

        lblUsuario = findViewById(R.id.lblUsuario)

        txtNombre = findViewById(R.id.txtNombre)
        txtNumeroRecibo = findViewById(R.id.txtNumero)
        txtHorasTrabajadas = findViewById(R.id.txtHoras)
        txtHorasExtras = findViewById(R.id.txtHorasExtras)

        rbAuxiliar = findViewById(R.id.rbAuxiliar)
        rbAlbañil = findViewById(R.id.rbAlbañil)
        rbIngObra = findViewById(R.id.rbIngObra)

        txtSubtotal = findViewById(R.id.txtSubTotal)
        txtImpuesto = findViewById(R.id.txtImpuestos)
        txtTotalPagar = findViewById(R.id.txttotalPagar)
    }

    private fun btnGenerar() {
        var puesto = 0


        reciboNomina.horasTrabajadas = txtHorasTrabajadas.text.toString().toDouble()
        reciboNomina.horasExtras = txtHorasExtras.text.toString().toDouble()


        puesto = when {
            rbAuxiliar.isChecked -> 1
            rbAlbañil.isChecked -> 2
            rbIngObra.isChecked -> 3
            else -> 0
        }



        reciboNomina.puesto = puesto
        val subtotal = reciboNomina.calcularSubtotal()
        txtSubtotal.setText(decimalFormat.format(subtotal))

        val impuesto = reciboNomina.calcularImpuesto()
        txtImpuesto.setText(decimalFormat.format(impuesto))

        val total = reciboNomina.calcularTotalPagar()
        txtTotalPagar.setText(decimalFormat.format(total))
    }

    private fun btnLimpiar() {
        txtNombre.setText("")
        txtNumeroRecibo.setText("")
        txtHorasExtras.setText("")
        txtHorasTrabajadas.setText("")
        txtSubtotal.setText("")
        txtImpuesto.setText("")
        txtTotalPagar.setText("")
    }
    private fun btnRegresar() {
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