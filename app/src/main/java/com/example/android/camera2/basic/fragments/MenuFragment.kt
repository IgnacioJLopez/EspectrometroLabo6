package com.example.android.camera2.basic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.android.camera2.basic.R
/* Este es el fragmento principal. Una vez que diste los permisos y elegiste la camera se abres te menu.
*  Descubri algo buenisimo. En nav_graph.xml podes ver como hacer se relacionan los fragmentos de manera visual.

* */
class MenuFragment: Fragment(){


    /** AndroidX navigation arguments */
    private val args: MenuFragmentArgs by navArgs() //con esto recibo datos de otros fragmentos

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.menu_inicial, container, false)
        val calibIntensidad = view.findViewById(R.id.CalibIntensidad) as Button
        val calibLongOnda = view.findViewById<Button>(R.id.CalibLongOnda)
        val alinear = view.findViewById<Button>(R.id.AutoRotar)

        calibIntensidad.setOnClickListener(
                {//actionMenu... hay que configurarla en nav_graph, correrlo y recien ahi aparece en este archivo
                    println("no hago nada")
                }
        )
        calibLongOnda.setOnClickListener(
                {
                    //Navigation.findNavController(requireActivity(), R.id.fragment_container)
                      //      .navigate(MenuFragmentDirections.actionMenuFragmentToLongOndaFragment(args.cameraId, args.pixelFormat))
                    println("no hago nada")
                }
        )
        alinear.setOnClickListener(
                {
                    Navigation.findNavController(requireActivity(), R.id.fragment_container)
                            .navigate(MenuFragmentDirections.actionMenuFragmentToAutoRotateFragment(args.cameraId, args.pixelFormat))
                }
        )

        return view
    }



}