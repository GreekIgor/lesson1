package com.example.lesson1.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lesson1.domain.ShopItem
import com.example.lesson1.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {

    private val showListLD = MutableLiveData<List<ShopItem>>()
    private var shopList = mutableListOf<ShopItem>()
    private var  autoIncrement=0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrement++
        }
            shopList.add(shopItem)
            updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
       var oldElement = getShopItem(shopItem.id)
           deleteShopItem(oldElement)
           addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
      //  return shopList.get(shopItemId)
        return shopList.find { it.id == shopItemId } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return  showListLD
    }

    private fun updateList()
    {
        showListLD.value = shopList.toList()
    }

}