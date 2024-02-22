package com.sayyam.itemsapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sayyam.itemsapp.domain.model.ItemUseCase

@Composable
fun ItemCard(item: ItemUseCase) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "ID: ${item.id}, List ID: ${item.listId}, Name: ${item.name ?: "N/A"}",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )
    }
}