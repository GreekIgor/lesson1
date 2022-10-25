package com.example.lesson1.domain

class AddShopItemUseCase (private val shopListReposity:ShopListRepository) {
    fun addShopItem(shopItem: ShopItem)
    {
        shopListReposity.addShopItem(shopItem)

    }
}