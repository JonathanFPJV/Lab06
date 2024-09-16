package com.example.lab06

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab06.ui.theme.Lab06Theme
import com.example.lab06.ui.theme.perfil.perfilUser
import com.example.lab06.ui.theme.home.HomeScreen
import com.example.lab06.ui.theme.configuracion.SettingsScreen
import com.example.lab06.ui.theme.menuham.MenuScreen
import com.example.lab06.ui.theme.favoritos.FavoriteScreen
import com.example.lab06.ui.theme.favoritos.listafavoritos
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp


enum class  indexscreen(){
    inicio,
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavHostController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = { navController.navigate("perfilUser") }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() } // Llamada a la función pasada como parámetro
    ) {
        Text(
            fontSize = 24.sp, // Tamaño de fuente del texto del botón
            text = "+" // Texto del botón
        )
    }
}

@Composable
fun NavigationHost(navController: NavHostController, padding: PaddingValues) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(padding) }
        composable("perfilUser") { perfilUser(padding) }
        composable("settings") { SettingsScreen(padding) }
        composable("menu") { MenuScreen(padding) }
        composable("favoritos") { FavoriteScreen(listafavoritos = listafavoritos, padding) }
    }
}

// Función Composable que crea un Scaffold personalizado
@Composable
fun CustomScaffold(
    navController: NavHostController = rememberNavController(),
) {
    var contadorfav by remember { mutableStateOf(0) }

    Scaffold(
        // Barra superior
        topBar = { CustomTopBar(navController = navController) },
        // Barra inferior
        bottomBar = { CustomBottomBar(navController = navController, contadorfav = contadorfav) },
        // Botón flotante personalizado
        floatingActionButton = {
            CustomFAB {
                // Incrementa el contador cada vez que el FAB es presionado
                contadorfav += 1
            }
        },
        // Contenido principal
        content = { padding ->
            NavigationHost(navController = navController, padding = padding)
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavHostController, contadorfav: Int) {
    BottomAppBar {
        IconButton(
            onClick = { navController.navigate("settings") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(Icons.Filled.Build, contentDescription = "Build description")
        }
        IconButton(
            onClick = { navController.navigate("menu") },
            modifier = Modifier.weight(1f)) {
            Icon(
                Icons.Filled.Menu,
                contentDescription = "Menu description",
            )
        }
        IconButton(
            onClick = { navController.navigate("home") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                Icons.Filled.Home,
                contentDescription = "Home description",
            )
        }
        IconButton(
            onClick = { navController.navigate("favoritos") },
            modifier = Modifier.weight(1f)) {
            Row {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite description")
                // Mostrar el contador junto al icono de favoritos
                if (contadorfav > 0) {
                    Text(
                        text = contadorfav.toString(),
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .align(Alignment.CenterVertically) // Alinear texto verticalmente
                    )
                }
            }
        }
        IconButton(
            onClick = { print("Delete") },
            modifier = Modifier.weight(1f)) {
            Icon(
                Icons.Filled.Delete,
                contentDescription = "Delete description",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun indexPreview() {
    Lab06Theme {
        CustomScaffold()
    }
}
