package main

import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
//    println("-----------------------------------")
//    addWithStringFromat(2, 3)
//
//    val daysOfWeek = listOf("MONDAY", "TUESDAY", "WEDNESDAY", "FRIDAY");
//
//    daysOfWeek.forEach { println(it) }
//    println("starts with T -----------------------------------")
//    daysOfWeek
//        .filter { string -> string.startsWith("T") }
//        .forEach { println(it) }
//    println("contains e -----------------------------------")
//    daysOfWeek
//        .filter { string -> string.contains("E") }
//        .forEach { println(it) }
//
//    println("length 6 -----------------------------------")
//    daysOfWeek
//        .filter { string -> string.length == 6 }
//        .forEach { println(it) }
//    println("prime range --------------------------------")
//    for (i in 1..100) {
//        if (isPrime(i)) {
//            print("$i, ")
//        }
//    }
//    println("msg coding --------------------------------")
//    fun myCoding(msg: String): String {
//        return msg
//            .map { char -> (char + 1).toChar() }
//            .joinToString("")
//    }
//
//    fun myDeCoding(msg: String): String {
//        return msg
//            .map { char -> (char - 1).toChar() }
//            .joinToString("")
//    }
//
//    val msg = "Akos vagyok"
//    println("message: $msg")
//    val cmsg = messageCoding(msg, ::myCoding)
//    println("encoded: $cmsg")
//    val dmsg = messageCoding(msg, ::myDeCoding)
//    println("decoded: $dmsg")
//    println("------------------------------")
//    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//    numbers
//        .filter { num -> isEven(num) }
//        .forEach { println(it) }
//
//    println("-----------------------------------")
//    numbers
//        .map { num -> num * 2 }
//        .forEach { println(it) }
//
//    println("--------------------------------------")
//    val daysOfWeek2 =
//        listOf("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday")
//    daysOfWeek2
//        .map { day -> print("${day.uppercase()} ") }
//
//    println("\n--------------------------------------")
//    daysOfWeek2
//        .map { day -> day.replaceFirstChar { c -> c.uppercase() } }
//        .forEach { print("$it ") }
//
//    println("\n--------------------------------------")
//    daysOfWeek2
//        .map { day -> print("${day.length} ") }
//
//    println("\n--------------------------------------")
//    print(daysOfWeek2
//        .map { day -> day.length }
//        .average())
//
//    println("\n--------------------------------------")
//    val daysOfWeek3 =
//        mutableListOf("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday")
//    daysOfWeek3.forEachIndexed { index, day ->
//        daysOfWeek3[index] = day.replaceFirstChar { it.uppercase() }
//    }
//    daysOfWeek3
//        .removeIf { day -> day.contains("n") }
//    print(daysOfWeek3)
//
//    println("\n--------------------------------------")
//    daysOfWeek3.withIndex().forEach { (index, day) ->
//        println("Item at $index is $day")
//    }
//
//    println("\n--------------------------------------")
//    daysOfWeek3.sort()
//    println(daysOfWeek3)
//
//    println("\n--------------------------------------")
//    val integerList = IntArray(10) { Random.nextInt(0, 101) }
//    println("The array: ")
//    integerList.forEach { println("$it") }
//
//    println("\n--------------------------------------")
//    integerList.sort()
//    integerList.forEach { print("$it ") }
//
//    println("\n--------------------------------------")
//    print(integerList.any { num -> num%2==0 })
//
//    println("\n--------------------------------------")
//    println(integerList.average()) //don't know why to use forEach, but one possible solution below
//    var temp = 0
//    var count = 0
//    integerList
//        .forEach { num ->
//            temp += num
//            count++
//         }
//    if (count != 0){
//        print(temp.toDouble()/count)
//    }
    groupAnagrams(listOf("eat", "tea", "tan", "ate", "nat", "bat"))
}

fun addWithStringFromat(number1: Int, number2: Int): Unit {
    println("$number1 + $number2 = ${number1 + number2}")
}

fun isPrime(number: Int): Boolean {
    if (number < 2) return false

    for (i in 2..Math.sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}

fun messageCoding(msg: String, func: (String) -> String): String {
    return func(msg);
}

fun isEven(number: Int): Boolean {
    return number % 2 == 0
}
fun groupAnagrams(strs:List<String>){
    var strsMap = mutableMapOf<String, MutableList<String>>()

    for (i in strs){
        val key = i.toCharArray().sorted().joinToString("")
        if(!strsMap.containsKey(key)){
            strsMap[key] = mutableListOf()
        }
    }
    for((key, value) in strsMap){
        for(str in strs){
            if(key == str.toCharArray().sorted().joinToString("")){
                strsMap[key]?.add(str)
            }
        }
    }

    for((key, value) in strsMap){
        println("$key: $value")
    }

}