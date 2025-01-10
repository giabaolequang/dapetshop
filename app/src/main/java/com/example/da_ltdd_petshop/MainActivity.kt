package com.example.da_ltdd_petshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.example.ban_meo.ui.theme.CustomTopAppBar
import com.example.ban_meo.ui.theme.InformationandWarrantyPolicyScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InformationandWarrantyPolicyScreen()
            }
        }
    }


