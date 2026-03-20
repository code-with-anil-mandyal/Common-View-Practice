package com.composeuipractice.screens.customViewPager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.composeuipractice.data.model.getCharacters
import com.composeuipractice.screens.components.HeaderScreen
import com.composeuipractice.utils.ProvideContext
import kotlin.math.absoluteValue

@Composable
fun CustomViewPager(){
Column {
    HeaderScreen(
        title = "ViewPager Screen"
    )

    Spacer(Modifier.height(10.dp))

    CustomViewPagerView()

}
}


@Composable
fun CustomViewPagerView() {

    val context = ProvideContext()

    val imagesList = remember {
        getCharacters(context) // ✅ load once
    }



    if (imagesList.isEmpty()) {
        Text("No data")
        return
    }

    val pagerState = rememberPagerState(
        pageCount = { imagesList.size }
    )

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 50.dp),//show side items
        pageSpacing = 5.dp, //gap between pages
        modifier = Modifier.fillMaxWidth()
            .height(400.dp)
    ) { page ->
        val pageOffset = (
                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                ).absoluteValue

        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = if (pageOffset < 0.5f) 12.dp else 4.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    val scale = 0.85f + (1 - pageOffset.coerceIn(0f, 1f)) * 0.15f
                    scaleX = scale
                    scaleY = scale
                }
        ) {
            AsyncImage(
                model = imagesList[page].image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }

}