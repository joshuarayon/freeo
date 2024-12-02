package com.plcoding.composegooglesignincleanarchitecture

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.painterResource

@Composable
fun PostPageScreen(navController: NavController) {
    var selectedImageUri by remember { mutableStateOf<String?>(null) } // Store the selected image URI
    var title by remember { mutableStateOf(TextFieldValue()) } // Title text field
    var description by remember { mutableStateOf(TextFieldValue()) } // Description text field

    // Open gallery for image selection
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        selectedImageUri = uri?.toString() // Store the URI of the selected image
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Placeholder image from drawable folder (when no image is selected)
        if (selectedImageUri == null) {
            Image(
                painter = painterResource(id = R.drawable.img), // Replace with your image resource
                contentDescription = "Select Image",
                modifier = Modifier
                    .size(200.dp) // Image size
                    .clickable { launcher.launch("image/*") } // Click to open gallery
            )
        } else {
            // Display the selected image if available
            selectedImageUri?.let { uri ->
                val painter: Painter = rememberImagePainter(uri)
                Image(
                    painter = painter,
                    contentDescription = "Selected Image",
                    modifier = Modifier.fillMaxWidth().height(200.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title input field
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description input field
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth().height(120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit button
        Button(
            onClick = {
                // Handle submission logic here
                if (selectedImageUri != null && title.text.isNotEmpty() && description.text.isNotEmpty()) {
                    // Submit the post
                    navController.popBackStack() // Navigate back to the previous screen
                }
            }
        ) {
            Text(text = "Submit")
        }
    }
}
