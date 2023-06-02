package com.example.pre_examen_kotlin_92

class ReciboNomina {


    var numRecibo: Int = 0
    var nombre: String
    var horasTrabajadas: Double = 0.0
    var horasExtras: Double = 0.0
    var puesto: Int = 0
    var impuestoPor: Double = 0.0




    constructor(
        numRecibo: Int,
        nombre: String,
        horasTrabajadas: Double,
        horasExtras: Double,
        puesto: Int,
        impuestoPor: Double
    ) {
        this.numRecibo = numRecibo
        this.nombre = nombre
        this.horasTrabajadas = horasTrabajadas
        this.horasExtras = horasExtras
        this.puesto = puesto
        this.impuestoPor = impuestoPor
    }


    fun calcularSubtotal(): Float {
        var resultado = 0.0
        val pagoBase = 200.0
        var pagoPorHoras = 0.0

        when (puesto) {
            1 -> pagoPorHoras = pagoBase + (pagoBase * 0.2)
            2 -> pagoPorHoras = pagoBase + (pagoBase * 0.5)
            3 -> pagoPorHoras = pagoBase + (pagoBase * 1.0)
        }

        resultado = (pagoBase * horasTrabajadas) + (horasExtras * pagoPorHoras * 2)

        return resultado.toFloat()
    }

    fun calcularImpuesto(): Float {
        val resultado = calcularSubtotal() * 0.16
        return resultado.toFloat()
    }

    fun calcularTotalPagar(): Float {
        val pagar = calcularSubtotal() - calcularImpuesto()
        return pagar.toFloat()
    }






}