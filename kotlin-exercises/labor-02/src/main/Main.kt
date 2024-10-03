package main

import kotlin.random.Random

fun main(args: Array<String>) {
    while (true) {
        println("Which problem do you want to see?")
        println("1 - Problem 1\n2 - Problem 2\n3 - Problem 3\n0 - Quit")

        val option = readLine()?.toIntOrNull()
        if (option == null) {
            println("Invalid input. Please enter a number.")
            continue
        }

        when (option) {
            1 -> problem1()
            2 -> problem2()
            3 -> problem3()
            0 -> {
                println("Quitting the program.")
                return
            }
            else -> println("Invalid option. Please try again.")
        }
    }
}

fun problem1(): Unit {
    val dict: IDictionary? = DictionaryProvider.createDictionary(DictionaryType.HASH_SET);
    println("Number of words: ${dict?.size()}")
    var word: String?
    while (true) {
        print("What to find? ")
        word = readLine()
        if (word.equals("quit")) {
            break
        }
        println("Result: ${word?.let { dict?.find(it) }}")
    }
}

fun problem2(): Unit {
    fun String.monogram(): String {
        return this.split(" ")
            .map { it.elementAt(0) }
            .joinToString("")
    }
    println("Kadar Akos Gergo".monogram())

    println("-------------------------------------------------")

    fun List<String>.joinWithGivenSeparator(separator: String): String {
        return this.joinToString(separator)
    }

    val myList = listOf("egy", "ketto", "alma", "szilva", "korte")
    println(myList.joinWithGivenSeparator("#"))

    println("-------------------------------------------------")

    fun List<String>.longest(): String {
        return this.maxBy { it.length }
    }
    println(myList.longest())
}

fun randomDate(): Date {
    val year = Random.nextInt(1900, 2100)
    val month = Random.nextInt(0, 15)
    val day = Random.nextInt(1, 42)
    return Date(year, month, day)
}

fun problem3() {
    val validDates = mutableListOf<Date>()

    while (validDates.size < 10) {
        val randomDate = randomDate()

        if (randomDate.isValid()) {
            validDates.add(randomDate)
            println("Valid date generated: ${randomDate.year}/${randomDate.month}/${randomDate.day}")
        } else {
            println("Invalid date generated: ${randomDate.year}/${randomDate.month}/${randomDate.day}")
        }
    }

    println("\nValid dates:")
    validDates.forEach { println("${it.year}/${it.month}/${it.day}") }

    println("\nSorted:")
    validDates.sort()
    validDates.forEach { println("${it.year}/${it.month}/${it.day}") }

    println("\nReversed:")
    validDates.reverse()
    validDates.forEach { println("${it.year}/${it.month}/${it.day}") }

    println("\nSorted by month:")
    val customSorted = validDates.sortedWith(compareBy { it.month })
    customSorted.forEach { println("${it.year}/${it.month}/${it.day}") }
    println()
}