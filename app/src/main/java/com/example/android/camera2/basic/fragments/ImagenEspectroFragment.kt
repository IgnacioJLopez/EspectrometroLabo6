package com.example.android.camera2.basic.fragments

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.graphics.rotationMatrix
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.android.camera2.basic.CameraActivity
import com.example.android.camera2.basic.R
import com.example.calibrarlongituddeonda.Autorotar
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class ImagenEspectroFragment: Fragment() {
    private val args: ImagenEspectroFragmentArgs by navArgs() //con esto recibo datos de otros fragmentos
    lateinit var canvasParaEditar: Canvas //para enchular los bitmaps hay que hacer esto
    lateinit var poneleColor: Paint //para ponerle colores
    lateinit var myBitmap: Bitmap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.imagen_espectro, container, false)
        var tita = args.tita
        val posHorizontalEspectro = args.b
        var matrix = rotationMatrix(tita)
        myBitmap = Bitmap.createBitmap(args.bitmap)//, 0, 0, args.bitmap.width, args.bitmap.height, matrix, true)
        var bitmapRotado = Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.width, myBitmap.height, matrix, true)
        println("tita2 = $tita")
        println("Xo2 = $posHorizontalEspectro")
        var alto = bitmapRotado.height

        var graphview: GraphView = view.findViewById(R.id.graph) as GraphView
        var series = LineGraphSeries<DataPoint>()

        for(i in 0..alto-1){
            var b = ((i-args.ordenCero)*args.relacion).toDouble()
            var argb = bitmapRotado.getPixel(args.b.toInt(), i)
            //var c = valor[i].toDouble()
            //var b = i.toDouble()
            var c = correcionIntensidad((Color.red(argb) + Color.blue(argb) + Color.green(argb)).toDouble())
            series.appendData(DataPoint(b, c), true, alto-1)
        }

        graphview.viewport.isXAxisBoundsManual = true
        graphview.viewport.setMinX(310.0)
        graphview.viewport.setMaxX(720.0)
        graphview.gridLabelRenderer.horizontalAxisTitle = "Longitud de onda (nm)"
        graphview.gridLabelRenderer.verticalAxisTitle = "Intensidad (u.a.)"
        graphview.addSeries(series)




        /*canvasParaEditar = Canvas(bitmapRotado)
        poneleColor = Paint()
        poneleColor.color = Color.argb(255, 0, 100, 255)
        canvasParaEditar.drawLine(posHorizontalEspectro, 0.0f,
                posHorizontalEspectro, bitmapRotado.height.toFloat(),
                        poneleColor)
        val imagenFinal = ImageView(requireContext()) //inicialization
        imagenFinal.layoutParams = LinearLayout.LayoutParams(bitmapRotado.width, bitmapRotado.height)

        imagenFinal.x = 0f
        imagenFinal.y = 0f
        imagenFinal.setImageBitmap(bitmapRotado)
        layout?.addView(imagenFinal)*/

        return view


    }

    fun correcionIntensidad(V:Double): Double{
        val a = args.h[2]
        val b = args.h[1]
        val c = args.h[0]
        if (V > 150){
            return (a*V*V+b*V+c)*V
        } else{
            return V
        }

    }



}