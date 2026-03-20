package com.composeuipractice.screens.horizontalScroll

import android.widget.HorizontalScrollView
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composeuipractice.screens.components.HeaderScreen

@Composable
fun HorizontalScrollScreen() {
    Column() {
        HeaderScreen(
            title = "Horizontal Scroll Screen"
        )

        Spacer(Modifier.height(10.dp))
        HorizontalScreenView()

    }
}

@Composable
fun HorizontalScreenView() {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        repeat(10){
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(100.dp)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Item $it"
                )
            }
        }
    }
}