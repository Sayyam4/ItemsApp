package com.sayyam.itemsapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sayyam.itemsapp.presentation.components.ItemCard
import com.sayyam.itemsapp.presentation.viewmodel.ItemViewModel

@Composable
fun ItemScreen() {
    val viewModel = hiltViewModel<ItemViewModel>()
    val items = viewModel.itemsList.collectAsState(emptyList()).value
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items) { item ->
                ItemCard(item = item)
            }
        }
    }
}