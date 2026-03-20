package com.composeuipractice.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ProvideContext(): Context {
    return LocalContext.current
}