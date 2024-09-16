package com.example.lab06.ui.theme.perfil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


@Composable
fun perfilUser(pading: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(pading)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = "https://via.placeholder.com/150"), // URL de la imagen o puedes usar una local
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.LightGray, CircleShape)
                    .padding(3.dp),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = "Jonathan Juli",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            color = Color.Black
        )

        Text(
            text = "Email: johndoe@example.com",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(
                onClick = { print("Edit Perfil") },
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit Profile")
            }

            IconButton(
                onClick = { print("Log Out") },
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Filled.Delete, contentDescription = "Log Out")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    MaterialTheme {
        perfilUser(pading = PaddingValues(0.dp))
    }
}


