package com.composeuipractice.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeuipractice.screens.components.HeaderScreen


@Composable
fun HomeScreen(
    onItemClick: (id: Int) -> Unit
){
    Column() {
        HeaderScreen(title = "Home Screen")
        Spacer(Modifier.height(10.dp))
        LazyColumn() {
            items(homeViewsList){ item ->
                HomeItem(
                    name = item.name,
                    id = item.id
                ){
                    onItemClick(item.id)
                }
            }
        }
    }

}



@Composable
fun HomeItem(
    name : String,
    id : Int,
    onClick: (id : Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .height(55.dp)
            .clickable {
                onClick(id)
            }
            .padding(20.dp, vertical = 5.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = name,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            textAlign = TextAlign.Center
        )
    }

    Spacer(modifier = Modifier
        .height(2.dp)
        .background(Color.Gray))
}