package com.composeuipractice.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.composeuipractice.screens.alertDialog.AlertDialogScreen
import com.composeuipractice.screens.customDialog.CustomDialogScreen
import com.composeuipractice.screens.customViewPager.CustomViewPager
import com.composeuipractice.screens.grdiLayout.GridLayoutScreen
import com.composeuipractice.screens.home.HomeScreen
import com.composeuipractice.screens.horizontalList.HorizontalListScreen
import com.composeuipractice.screens.horizontalScroll.HorizontalScrollScreen
import com.composeuipractice.screens.verticalList.VerticalListScreen
import com.composeuipractice.screens.verticalScroll.VerticalScrollScreen
import com.composeuipractice.screens.viewPager.ViewPagerScreen

@Composable
fun Navigation(modifier: Modifier){
        val navController = rememberNavController()

        NavHost(
                navController = navController,
                startDestination = ScreenRoutes.HomeScreen.route,
                modifier = modifier
        ){
                composable(ScreenRoutes.HomeScreen.route){
                        HomeScreen( onItemClick = { id ->
                                when(id){
                                    1 ->{
                                            navController.navigate(ScreenRoutes.VerticalListScreen.route)
                                    }
                                    2 ->{
                                            navController.navigate(ScreenRoutes.HorizontalListScreen.route)
                                    }
                                    3 ->{
                                            navController.navigate(ScreenRoutes.GridLayoutScreen.route)
                                    }
                                    4 ->{
                                        navController.navigate(ScreenRoutes.AlertDialogScreen.route)
                                    }
                                    5 ->{
                                        navController.navigate(ScreenRoutes.CustomDialogScreen.route)
                                    }
                                    6 ->{
                                        navController.navigate(ScreenRoutes.HorizontalScrollScreen.route)
                                    }
                                    7 ->{
                                        navController.navigate(ScreenRoutes.VerticalScrollScreen.route)
                                    }

                                    8 ->{
                                        navController.navigate(ScreenRoutes.ViewPagerScreen.route)
                                    }
                                    9 ->{
                                        navController.navigate(ScreenRoutes.CustomViewPager.route)
                                    }
                                }
                        })
                }
                composable(ScreenRoutes.VerticalListScreen.route){
                        VerticalListScreen()
                }

                composable(ScreenRoutes.HorizontalListScreen.route){
                        HorizontalListScreen()
                }

                composable(ScreenRoutes.GridLayoutScreen.route){
                        GridLayoutScreen()
                }
                composable(ScreenRoutes.AlertDialogScreen.route){
                    AlertDialogScreen()
                }

                composable(ScreenRoutes.CustomDialogScreen.route){
                    CustomDialogScreen()
                }

                composable(ScreenRoutes.HorizontalScrollScreen.route){
                    HorizontalScrollScreen()
                }
                composable(ScreenRoutes.VerticalScrollScreen.route){
                    VerticalScrollScreen()
                }

            composable(ScreenRoutes.ViewPagerScreen.route){
                ViewPagerScreen()
            }

            composable(ScreenRoutes.CustomViewPager.route){
                CustomViewPager()
            }
        }
}