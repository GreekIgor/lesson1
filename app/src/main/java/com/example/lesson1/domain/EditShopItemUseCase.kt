package com.example.lesson1.domain

class EditShopItemUseCase (private val shopListReposity:ShopListRepository) {
    fun editShopItem(shopItem: ShopItem)
    {
        shopListReposity.editShopItem(shopItem)
    }
}