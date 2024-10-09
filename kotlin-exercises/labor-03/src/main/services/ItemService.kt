package main.services

import main.entities.Item
import main.repositories.ItemRepository

class ItemService {
    val itemRepository = ItemRepository()



    fun selectRandomItem(number: Int): List<Item> {
        if (number < 1) {
            throw IllegalArgumentException("Number must be greater than 0")
        }

        if (number > itemRepository.size()) {
            throw IllegalArgumentException("Number must be less than or equal to ${itemRepository.size()}")
        }
        val items = mutableListOf<Item>()
        while (items.size < number) {
            val item = itemRepository.randomItem()
            if (!items.contains(item)) {
                items.add(item)
            }
        }
        return items
    }
}