package com.composeuipractice.screens.alertDialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.composeuipractice.screens.components.HeaderScreen

@Composable
fun AlertDialogScreen(modifier: Modifier = Modifier) {

    var showDialog by remember { mutableStateOf(false) }

    Column() {
        HeaderScreen(
            title = "Alert Dialog Screen"
        )
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            Button(
                modifier = Modifier.align(alignment = Alignment.Center)
                ,onClick = {
                showDialog = true
            }) {
                Text(
                    text = "Show Alert Dialog"
                )
            }

            ShowAlterDialog(
                show = showDialog,
                onDismiss = { showDialog = false}
            )
        }
    }
}

@Composable
fun ShowAlterDialog(
    show : Boolean,
    onDismiss : () -> Unit
) {
        if(!show) return

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Delete")},
        text = { Text("Are you sure you want to delete this item?") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Yes")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("No")
            }
        }
    )
}