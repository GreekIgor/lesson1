package com.example.lesson1.domain

class DeleteShopItemUseCase (private val shopListReposity:ShopListRepository) {
    fun deleteShopItem(shopItem: ShopItem)
    {
        shopListReposity.deleteShopItem(shopItem)
		
		
		
		

    }
}