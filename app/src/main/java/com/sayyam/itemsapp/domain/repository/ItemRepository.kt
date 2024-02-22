package com.sayyam.itemsapp.domain.repository

import com.sayyam.itemsapp.domain.model.ItemUseCase
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    suspend fun getItems(): Flow<List<ItemUseCase>>
}