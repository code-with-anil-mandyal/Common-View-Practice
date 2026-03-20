package com.composeuipractice.screens.customDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.composeuipractice.screens.components.HeaderScreen

@Composable
fun CustomDialogScreen() {


    Column() {
        HeaderScreen(
            title = "Custom Dialog Screen"
        )

        Spacer(Modifier.height(10.dp))
        ShowCustomDialog()
    }
}

@Composable
fun ShowCustomDialog() {

    var showDialog by remember { mutableStateOf(false) }

    Button(
        onClick = {
        showDialog = true
    }) {
        Text(
            text = "Show Custom dialog"
        )


    }

    if(showDialog){
        Dialog(
            onDismissRequest = {
                showDialog = false
            }
        ) {
            CardUi(
                title = "Custom Dialog",
                description = "This is a custom dialog created using Jetpack Compose.",
                onShow = {
                    showDialog = it
                }
            )
        }
    }



}

@Composable
fun CardUi(
           title: String,
           description: String,
    onShow : (Boolean) -> Unit

) {

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = description
            )

            Spacer(Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(
                    onClick = {
                        onShow(false)
                    }
                ) {
                    Text(
                        text = "Cancel"
                    )
                }

                TextButton(
                    onClick = {
                        onShow(false)
                    }
                ) {
                    Text(
                        text = "Ok"
                    )
                }
            }
        }

    }
}