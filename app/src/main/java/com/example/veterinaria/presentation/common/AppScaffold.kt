package com.example.veterinaria.presentation.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.veterinaria.ui.theme.FondoPawsy

@Composable
fun AppScaffold(navHostController: NavHostController, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        containerColor = FondoPawsy,
        topBar = { AppTopBar(navHostController) },
        bottomBar = { AppBottomBar(navHostController) }
    ) { paddingValues ->
        content(paddingValues)
    }
}
