package com.composeuipractice.screens.horizontalList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.composeuipractice.data.model.CharactersResponse
import com.composeuipractice.data.model.getCharacters
import com.composeuipractice.screens.components.HeaderScreen
import com.composeuipractice.utils.ProvideContext

@Composable
fun HorizontalListScreen() {

    val context = ProvideContext()

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderScreen(
            title = "Horizontal List Screen"
        )

        LazyRow(
            modifier = Modifier.padding(20.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(getCharacters(context)){
                HorizontalListItem(it)
            }
        }
    }
}

@Composable
fun HorizontalListItem(
    charactersResponse: CharactersResponse
) {
    Card(
        modifier = Modifier
            .padding(start = 5.dp)
            .height(200.dp)
            .width(150.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        AsyncImage(
            model = charactersResponse.image,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .clip(RectangleShape),
            contentScale = ContentScale.Crop
        )
    }
}