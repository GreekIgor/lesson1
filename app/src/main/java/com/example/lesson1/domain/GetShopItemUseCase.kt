package com.example.lesson1.domain

class GetShopItemUseCase (private val shopListReposity:ShopListRepository) {

    fun getShopItem(shopItemId: Int): ShopItem {
      return  shopListReposity.getShopItem(shopItemId)
    }
}