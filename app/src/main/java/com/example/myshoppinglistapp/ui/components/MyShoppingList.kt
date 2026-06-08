package com.example.myshoppinglistapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.myshoppinglistapp.data.local.ShoppingItem

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyShoppingList(modifier: Modifier = Modifier) {

    var shoppingItem by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center

    ) {
        Button(
            onClick = { showDialog = true },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Add Item")
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
        ) {
            items(shoppingItem){

            }
        }
    }

    if(showDialog){
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = {
                    if(itemName.isNotBlank()){
                        var newItem = ShoppingItem(
                            shoppingItem.size + 1,
                            itemName,
                            itemQuantity.toInt()
                        )
                        shoppingItem = shoppingItem + newItem
                        showDialog = false
                        itemName = ""
                        itemQuantity = ""
                        } else {
                        showDialog = false
                        itemName = ""
                        itemQuantity = ""
                    }
                }) {
                    Text("Add")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            },
            title = { Text("Add Shopping Item") },
            text = {
                Column() {
                    OutlinedTextField(
                        itemName,
                        onValueChange = {itemName = it},
                        singleLine = true,
                        modifier = Modifier.padding(8.dp).fillMaxWidth(),
                        label = {
                            Text("Item Name",
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    )
                    OutlinedTextField(
                        itemQuantity,
                        onValueChange = {itemQuantity = it},
                        singleLine = true,
                        modifier = Modifier.padding(8.dp).fillMaxWidth(),
                        label = {
                            Text("Quantity",
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    )
                }
            },
            )
    }
}