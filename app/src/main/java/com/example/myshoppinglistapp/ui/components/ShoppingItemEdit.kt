package com.example.myshoppinglistapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.myshoppinglistapp.data.local.ShoppingItem

@Composable
fun ShoppingItemEdit(item: ShoppingItem, onEditComplete: (String,Int)-> Unit) {
    var editedName by remember { mutableStateOf(item.name) }
    var editedQuantity by remember { mutableStateOf(item.quantity.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }

    Row(
        modifier = Modifier.padding(8.dp).fillMaxWidth().background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        if (isEditing) {
            Column() {
                OutlinedTextField(
                    editedName,
                    onValueChange = {editedName = it},
                    singleLine = true,
                    modifier = Modifier.wrapContentSize().padding(8.dp),
                    label = {
                        Text("Item Name",
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                )
                OutlinedTextField(
                    editedQuantity,
                    onValueChange = {editedQuantity = it},
                    singleLine = true,
                    modifier = Modifier.wrapContentSize().padding(8.dp),
                    label = {
                        Text("Item Name",
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                )
                Button(
                    onClick = {
                        isEditing = false
                        onEditComplete(editedName, editedQuantity.toIntOrNull()?:1)
                    }
                ) {
                    Text("Save")
                }
            }
                }
            }
        }