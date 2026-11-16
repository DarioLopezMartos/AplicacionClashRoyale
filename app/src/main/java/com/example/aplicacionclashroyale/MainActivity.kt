package com.example.aplicacionclashroyale

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.aplicacionclashroyale.ui.theme.AplicacionClashRoyaleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AplicacionClashRoyaleTheme {
                AppPantallas()
            }
        }
    }
}