package com.example.calibrarlongituddeonda

class CalibrarLongOnda() {


    var posicionesMaximos = ArrayList<Int>()
    var posicionesMinimos = ArrayList<Int>()
    var ordenCero = 0
    var primerMaximo = 0
    var indiceOrdenCero = 0


    fun maxMinFinder(intensidades: FloatArray) {

        val ancho = 7 //ancho con el que defino que un punto es un maximo o minimo
        for (i in ancho+1..intensidades.size - (ancho+1)) {
            if (intensidades[i] >= intensidades.sliceArray(i-ancho..i-1).max()!! &&
                intensidades[i] >= intensidades.sliceArray(i+1..i+ancho).max()!! && intensidades[i] > 80)
            {
                println("max en $i de ${intensidades[i]}")
                posicionesMaximos.add(i)

                if(intensidades[i]>700){
                    indiceOrdenCero = posicionesMaximos.size-1
                }
            }

            if (intensidades[i] < intensidades.sliceArray(i-ancho..i-1).min()!! &&
                intensidades[i] < intensidades.sliceArray(i+1..i+ancho).min()!!)
            {
                println("min en $i de ${intensidades[i]}")
                posicionesMinimos.add(i)
            }
        }

        ordenCero = posicionesMaximos[indiceOrdenCero]
        primerMaximo = posicionesMaximos.last()

    }


}