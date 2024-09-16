package com.example.lab06.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.lab06.CustomScaffold
import com.example.lab06.ui.theme.Lab06Theme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow

@Composable
fun HomeScreen(padding: PaddingValues) {
    Column(modifier = Modifier.fillMaxSize().padding(padding)) {
        Text(
            text = "Categorías",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = "https://via.placeholder.com/400x300"), // URL de la imagen
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(width = 200.dp, height = 120.dp)  // Tamaño más rectangular
                    .clip(RoundedCornerShape(12.dp))  // Bordes ligeramente redondeados
                    .background(Color.LightGray)  // Color de fondo antes de cargar la imagen
                    .border(
                        width = 2.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(12.dp)  // Bordes coinciden con el recorte
                    )
                    .shadow(4.dp, RoundedCornerShape(12.dp))  // Añadir sombra ligera
                    .padding(4.dp),
                contentScale = ContentScale.Crop  // Ajusta la imagen al tamaño
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        Box(){
            Row(

            ){
                IconButton(
                    onClick = { print("Build") },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Filled.Build, contentDescription = "Build description")
                }
                IconButton(
                    onClick = { print("Build") },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Filled.Build, contentDescription = "Build description")
                }
                IconButton(
                    onClick = { print("Build") },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Filled.Build, contentDescription = "Build description")
                }
            }
        }

    }
}

