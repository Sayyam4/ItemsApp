package com.sayyam.itemsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sayyam.itemsapp.domain.model.ItemUseCase
import com.sayyam.itemsapp.domain.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {
    private val _itemsList = MutableStateFlow<List<ItemUseCase>>(emptyList())

    val itemsList: StateFlow<List<ItemUseCase>> = _itemsList

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            itemRepository.getItems()
                .collect{ items ->
                    val filteredItems = items.filter { it.name?.isNotBlank() == true }
                    val sortedItems = filteredItems.sortedWith(compareBy({ it.listId }, { it.name }))
                    _itemsList.value = sortedItems
                }
        }
    }
}
