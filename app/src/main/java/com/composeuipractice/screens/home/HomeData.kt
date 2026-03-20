package com.composeuipractice.screens.home

data class HomeData(
    val id : Int,
    val name : String
)


val homeViewsList = listOf(
    HomeData(1, "Vertical List"),
    HomeData(2, "Horizontal List"),
    HomeData(3, "Grid Layout"),
    HomeData(4, "Alert Dialog"),
    HomeData(5, "Custom Dialog"),
    HomeData(6, "Horizontal Scroll"),
    HomeData(7, "Vertical Scroll Screen"),
    HomeData(8, "ViewPager Screen"),
    HomeData(9, "ViewPager Custom Screen")
)

