package com.example.lab06.ui.theme.favoritos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

// Datos de ejemplo de autopartes favoritas
data class AutoPart(val id: Int, val name: String)

val listafavoritos = listOf(
    AutoPart(1, "Filtro de aire"),
    AutoPart(2, "Bujías"),
    AutoPart(3, "Aceite de motor"),
    AutoPart(4, "Pastillas de freno"),
    AutoPart(5, "Radiador")
)

@Composable
fun FavoriteScreen(listafavoritos: List<AutoPart>,padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Autopartes Favoritas",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Lista de partes favoritas
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listafavoritos) { part ->
                FavoriteItem(part)
            }
        }
    }
}

@Composable
fun FavoriteItem(part: AutoPart) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = "https://via.placeholder.com/150"), // URL de la imagen o puedes usar una local
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color.LightGray)
                        .padding(3.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = part.name, style = MaterialTheme.typography.bodyLarge)
            IconButton(onClick = { /* Acción para eliminar de favoritos */ }) {
                Icon(Icons.Filled.Delete, contentDescription = "Eliminar de Favoritos")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    MaterialTheme {
        FavoriteScreen(listafavoritos,padding = PaddingValues(0.dp))
    }
}
