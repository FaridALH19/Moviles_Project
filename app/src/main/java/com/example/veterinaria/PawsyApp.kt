package com.example.veterinaria

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Punto de entrada de Hilt: debe registrarse en el AndroidManifest (android:name=".PawsyApp")
@HiltAndroidApp
class PawsyApp : Application()
