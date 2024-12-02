package com.plcoding.composegooglesignincleanarchitecture

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.navigation.NavController

@Composable
fun HomePageScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Column for the main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 64.dp), // Padding to make room for the floating button
            verticalArrangement = Arrangement.SpaceBetween, // Space between elements
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Welcome message at the top of the page
            Text(text = "Care to Share!", style = MaterialTheme.typography.h4)
            Spacer(modifier = Modifier.height(16.dp))

            // Spacer to push content towards the top
            Spacer(modifier = Modifier.weight(1f)) // Push buttons to the bottom

            // Row for the two buttons at the bottom of the screen
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Add padding for the buttons
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Post Button
                Button(
                    onClick = {   navController.navigate("post") },
                    modifier = Modifier.weight(1f) // Button takes up equal space
                ) {
                    Text(text = "Post")
                }

                // Message Button
                Spacer(modifier = Modifier.width(16.dp)) // Spacer between the buttons
                Button(
                    onClick = { /* Handle Message action here */ },
                    modifier = Modifier.weight(1f) // Button takes up equal space
                ) {
                    Text(text = "Message")
                }
            }
        }

        // Floating Action Button in the top-left corner
        FloatingActionButton(
            onClick = {
                navController.navigate("profile") // Navigate to profile screen
            },
            modifier = Modifier
                .padding(16.dp) // Padding from edges
                .align(Alignment.TopStart), // Align to the top-left
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile",
                tint = Color.White
            )
        }
    }
}
