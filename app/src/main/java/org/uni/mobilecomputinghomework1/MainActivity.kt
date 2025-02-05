package org.uni.mobilecomputinghomework1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import org.uni.mobilecomputinghomework1.ui.theme.MobileComputingHomework1Theme

//TODO: change the project name
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileComputingHomework1Theme {
                Navigation()
            }
        }
    }
}