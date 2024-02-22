package com.sayyam.itemsapp.data.network

import com.sayyam.itemsapp.data.model.Item
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {
    @GET("hiring.json")
    suspend fun getItems(): Flow<List<Item>>
}