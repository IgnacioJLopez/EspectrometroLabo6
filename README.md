
Espectrometria con smartphones
===========================

Esta aplicación fue desarrollada en el marco de la materia Laboratorio 6 de la
Facultad de Ciencias Exactas y Naturales de la Universidad de Buenos Aires.
En el Laboratorio de Óptica y Fotónica del Departamento de Física.

Introducción
------------

Espectrometria con smartphones hace posible medir espectros relativos en
telefonos celulares con calibraciones y correcciones automaticas. Se adaptó
el ejemplo de Camera2 de la documentación de Android para poder controlar 
la cámara.
The [Camera2 API][1] allows users to capture RAW images, i.e. unprocessed pixel data
directly from the camera sensor that has not yet been converted into a format and
colorspace typically used for displaying and storing images viewed by humans.  The
[DngCreator][2] class is provided as part of the Camera2 API as a utility for saving
RAW images as DNG files.

This sample displays a live camera preview in a TextureView, and saves JPEG and DNG
file for each image captured.

[1]: https://developer.android.com/reference/android/hardware/camera2/package-summary.html
[2]: https://developer.android.com/reference/android/hardware/camera2/DngCreator.html


Screenshots
-------------

<img src="screenshots/main.jpg" height="400" alt="Screenshot"/> 
