package com.composeuipractice.screens.grdiLayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.composeuipractice.data.model.CharactersResponse
import com.composeuipractice.data.model.getCharacters
import com.composeuipractice.screens.components.HeaderScreen
import com.composeuipractice.utils.ProvideContext

@Composable
fun GridLayoutScreen() {

    val context = ProvideContext()

    Column() {
        HeaderScreen(
            title = "Grid Layout Screen"
        )
        Spacer(Modifier.height(10.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(getCharacters(context)){ character ->
                GridCardItem(character)
            }
        }
    }
}

@Composable
fun GridCardItem(
    charactersResponse: CharactersResponse
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(230.dp)
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
         Column(modifier = Modifier
             .fillMaxSize()
             .padding(10.dp)
         ) {
             AsyncImage(
                 model = charactersResponse.image,
                 contentDescription = "",
                 modifier = Modifier
                     .fillMaxSize()
                     .clip(RectangleShape),
                 contentScale = ContentScale.FillBounds
             )
             Spacer(Modifier.height(10.dp))
             Text(
                 text = charactersResponse.name?:"",
                 style = TextStyle(
                     fontWeight = FontWeight.SemiBold,
                     fontSize = 15.sp,
                     color = Color.Black
                 )
             )
         }
    }

}