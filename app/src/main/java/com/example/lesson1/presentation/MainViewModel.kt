package com.example.lesson1.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.lesson1.data.ShopListRepositoryImpl
import com.example.lesson1.domain.*

class MainViewModel: ViewModel() {

    private var repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
     }

    fun changeEnableState(shopItem: ShopItem)
    {
        val newItem = shopItem.copy(enabled =  !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}