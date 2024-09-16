package com.example.lab06.ui.theme.menuham

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(padding: PaddingValues) {
    // Estructura principal del menú
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Menú Principal - Almacén de Autopartes",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Botones del menú
        Button(
            onClick = { /* Navegar a Inventario */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Inventario")
        }

        Button(
            onClick = { /* Navegar a Pedidos */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Pedidos")
        }

        Button(
            onClick = { /* Navegar a Clientes */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Clientes")
        }

        Button(
            onClick = { /* Navegar a Proveedores */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Proveedores")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AutoPartsMenuScreenPreview() {
    MaterialTheme {
        MenuScreen(padding = PaddingValues(0.dp))
    }
}
