package com.example.calibrarlongituddeonda

import android.graphics.Bitmap
import android.graphics.Color

class Autorotar (myBitmap: Bitmap){

    private var alto = myBitmap.height
    private val ancho = myBitmap.width

    fun pendiente(myBitmap: Bitmap): DoubleArray{
        val intensidad = IntArray(ancho)
        val maximosI = arrayListOf<Double>()
        val maximosX = arrayListOf<Double>()
        val maximosY = arrayListOf<Double>()

        for(y in 0 until (alto-1)/10) {
            var iteradorI = 0
            var iteradorX = 0
            for (x in 0 until ancho-1) { //Ahora mas rapido
                val argb = myBitmap.getPixel(x, 10*y)
                intensidad[x] = (Color.red(argb) + Color.blue(argb) + Color.green(argb))
                if (intensidad[x] > iteradorI && intensidad[x] > 127) {
                    iteradorI = intensidad[x]
                    iteradorX = x
                }
            }

            if (iteradorI > 0) {
                maximosX.add(iteradorX.toDouble())
                maximosY.add(10*y.toDouble())
                maximosI.add(iteradorI.toDouble())

            }

        }

        val regresion = Regresion()
        val m = regresion.getPolynomialFitter(maximosY, maximosX,1)
        return m
    }
    var m  = pendiente(myBitmap)

    var tita = 180*kotlin.math.atan(m[1])/3.1416

}
