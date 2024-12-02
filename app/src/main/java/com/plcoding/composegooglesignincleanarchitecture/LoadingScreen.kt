package com.plcoding.composegooglesignincleanarchitecture


import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.plcoding.composegooglesignincleanarchitecture.presentation.sign_in.UserData
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
    userData: UserData?,
    onSignOut: () -> Unit,
    onNavigateToHomepage: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (userData?.profilePictureUrl != null) {
                AsyncImage(
                    model = userData.profilePictureUrl,
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Text(
                text = "Welcome, ${userData?.username ?: "User"}!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            // Automatically navigate to Homepage if the user is signed in
            LaunchedEffect(key1 = userData) {
                if (userData != null) { // Only navigate if the user is signed in
                    delay(2000)  // Wait for 2 seconds before navigating
                    onNavigateToHomepage()  // Navigate to homepage
                }
            }
        }
    }
}
