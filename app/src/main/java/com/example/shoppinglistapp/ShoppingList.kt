package com.example.shoppinglistapp

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ShoppingItem( val id: Int,
                         var name: String,
                         var quantity: Int,
                         var isEditing: Boolean=false
)

@Composable
fun ShoppingListApp() {

    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false)}
    var itemName  by remember { mutableStateOf("")}
    var itemQuantity  by remember { mutableStateOf("")}

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                {showDialog=true},
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Add Item")
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(sItems) {

                }
            }
        }
        if (showDialog){

            AlertDialog({showDialog=false},
                {},
            title ={ Text("Add Shopping Item")},
                text = {
                    Column() {
                        OutlinedTextField(itemName,
                            { itemName=it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth().padding(8.dp))
                        OutlinedTextField(itemQuantity,
                            { itemQuantity=it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth().padding(8.dp))
                    }
                }
            )
        }
    }
}