package com.routiner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.routiner.ui.RoutinerApp
import com.routiner.ui.theme.RoutinerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoutinerTheme {
                RoutinerApp()
            }
        }
    }
}
