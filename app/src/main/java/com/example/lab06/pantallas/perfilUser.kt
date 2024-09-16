package com.example.lab06.pantallas

import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.lab06.CustomScaffold
import com.example.lab06.ui.theme.Lab06Theme

@Composable
fun perfilUser(padding: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        Text(text = "Perfil del Usuario", fontSize = 24.sp)
        Text(text = "Perfil del Usuario", fontSize = 24.sp)
        Text(text = "Perfil del Usuario", fontSize = 24.sp)
        Text(text = "Perfil del Usuario", fontSize = 24.sp)
        Text(text = "Perfil del Usuario", fontSize = 24.sp)
        Text(text = "Perfil del Usuario", fontSize = 24.sp)
        // Aquí puedes agregar más contenido del perfil, como información del usuario
    }

}

