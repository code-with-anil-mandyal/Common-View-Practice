package com.composeuipractice.screens.viewPager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.composeuipractice.data.model.getCharacters
import com.composeuipractice.screens.components.HeaderScreen
import com.composeuipractice.utils.ProvideContext

@Composable
fun ViewPagerScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderScreen(
            title = "ViewPager Screen"
        )



        ViewPagerView(
            modifier = Modifier.weight(1f)
        )

    }
}

@Composable
fun ViewPagerView(
    modifier: Modifier
) {

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
        modifier = Modifier.fillMaxSize()
    ) { page ->
        AsyncImage(
            model = imagesList[page].image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }

}