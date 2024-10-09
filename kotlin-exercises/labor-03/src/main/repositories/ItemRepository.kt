package main.repositories

import main.entities.Item
import java.io.File

class ItemRepository {
    val items = mutableListOf<Item>()

    init {
        val file = File("items.txt")
        if (file.exists()) {
            val lines = file.readLines()
            var i = 0
            while (i < lines.size) {
                val question = lines[i].toString()
                val answers = lines[i+1].split(", ").toList()
                val correctAnswer = lines[i+2].toInt()

                i += 3
                val item = Item(answers, question, correctAnswer)
                items.add(item)
            }
        } else {
            println("File not found")
        }
    }

    fun randomItem(): Item {
        return items.random()
    }

    fun save(item: Item): Unit {
        items.add(item)
    }

    fun size(): Int {
        return items.size
    }
}