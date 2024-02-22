package com.sayyam.itemsapp.data.repository

import com.sayyam.itemsapp.data.network.ApiService
import com.sayyam.itemsapp.domain.model.ItemUseCase
import com.sayyam.itemsapp.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): ItemRepository {
    override suspend fun getItems(): Flow<List<ItemUseCase>> {
        return apiService.getItems().map { items ->
            items.map { item ->
                ItemUseCase(
                    id = item.id,
                    listId = item.listId,
                    name = item.name
                )
            }
        }
    }
}