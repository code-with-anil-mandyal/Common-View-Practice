package com.composeuipractice.screens.verticalScroll

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.composeuipractice.screens.components.HeaderScreen

@Composable
fun VerticalScrollScreen() {
    Column() {
        HeaderScreen(
            title = "Vertical Scroll Screen"
        )

        Spacer(Modifier.height(10.dp))

        VerticalScreenView()


    }
}

@Composable
fun VerticalScreenView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       // repeat(20){

            CircleShapeImage(1)
            Spacer(Modifier.height(10.dp))
            CircleShapeImage(2)
            Spacer(Modifier.height(10.dp))
            CircleShapeImage(3)
            Spacer(Modifier.height(10.dp))
            CircleShapeImage(4)
            Spacer(Modifier.height(10.dp))
            CircleShapeImage(5)
            Spacer(Modifier.height(10.dp))

        CircleShapeImage(1)
        Spacer(Modifier.height(10.dp))
        CircleShapeImage(2)
        Spacer(Modifier.height(10.dp))
        CircleShapeImage(3)
        Spacer(Modifier.height(10.dp))
        CircleShapeImage(4)
        Spacer(Modifier.height(10.dp))
        CircleShapeImage(5)
        Spacer(Modifier.height(10.dp))

      //  }
    }
}

@Composable
fun CircleShapeImage(type : Int) {
    when(type){
        //Circle Image
        1 ->{
            AsyncImage(
                model = "https://ik.imagekit.io/hpapi/harry.jpg",
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape), // ✅ circle
                contentScale = ContentScale.Crop
            )
        }
        //Rounded Corner Image
        2 ->{
            AsyncImage(
                model = "https://ik.imagekit.io/hpapi/harry.jpg",
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(16.dp)), // ✅ rounded
                contentScale = ContentScale.Crop
            )
        }

        //Custom Shape (cut corners / different radii)
        3 ->{
            AsyncImage(
                model = "https://ik.imagekit.io/hpapi/harry.jpg",
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 0.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 16.dp)), // ✅ rounded
                contentScale = ContentScale.Crop
            )
        }

        //Custom Shape (cut corners / different radii)
        3 ->{
            AsyncImage(
                model = "https://ik.imagekit.io/hpapi/harry.jpg",
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 0.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 16.dp)), // ✅ rounded
                contentScale = ContentScale.Crop
            )
        }

        //Add Border (common requirement)
        4 ->{
            AsyncImage(
                model = "https://ik.imagekit.io/hpapi/harry.jpg",
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Blue, CircleShape), // ✅ border
                contentScale = ContentScale.Crop
            )
        }
        //Image with shadow + shape (clean UI)
        5 ->{
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                AsyncImage(
                    model = "https://ik.imagekit.io/hpapi/harry.jpg",
                    contentDescription = null,
                    modifier = Modifier.size(120.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

    }
}