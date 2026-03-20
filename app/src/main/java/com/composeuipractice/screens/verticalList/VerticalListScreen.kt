package com.composeuipractice.screens.verticalList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun VerticalListScreen() {
    Column() {
        val context = ProvideContext()
        HeaderScreen(title = "Vertical List Screen")

        Spacer(Modifier.height(10.dp))

        LazyColumn() {
            items(getCharacters(context)){ character ->
                VerticalItem(character = character)
            }
        }
    }
}

@Composable
fun VerticalItem(
   character: CharactersResponse
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = "",
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
                    .clip(RectangleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(10.dp))
            Column(
            ) {
                Text(
                    text = character.name?:"",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                )

                Text(
                    text = character.dateOfBirth?:"",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp
                    )
                )

                Text(
                    text = character.gender?:"",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp
                    )
                )
            }
        }
    }

}