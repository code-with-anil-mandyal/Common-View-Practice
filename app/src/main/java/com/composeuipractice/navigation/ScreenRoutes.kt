package com.composeuipractice.navigation

sealed class ScreenRoutes(val route : String){
    object HomeScreen : ScreenRoutes("home_screen")
    object VerticalListScreen : ScreenRoutes("vertical_list_screen")
    object HorizontalListScreen : ScreenRoutes("horizontal_list_screen")
    object GridLayoutScreen : ScreenRoutes("grid_layout_screen")
    object AlertDialogScreen : ScreenRoutes("alert_dialog_screen")
    object CustomDialogScreen : ScreenRoutes("custom_dialog_screen")
    object HorizontalScrollScreen : ScreenRoutes("horizontal_scroll_screen")
    object VerticalScrollScreen : ScreenRoutes("vertical_scroll_screen")
    object ViewPagerScreen : ScreenRoutes("view_pager_screen")
    object CustomViewPager : ScreenRoutes("custom_view_pager")
}