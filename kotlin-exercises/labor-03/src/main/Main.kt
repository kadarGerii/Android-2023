package main

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    println("-----------------------------------")
    addWithStringFromat(2,3)

    val daysOfWeek = listOf("MONDAY", "TUESDAY", "WEDNESDAY", "FRIDAY");

    daysOfWeek.forEach { println(it)}
    println("starts with T -----------------------------------")
    daysOfWeek
        .filter { string -> string.startsWith("T") }
        .forEach { println(it) }
    println("contains e -----------------------------------")
    daysOfWeek
        .filter { string -> string.contains("E") }
        .forEach { println(it) }

    println("length 6 -----------------------------------")
    daysOfWeek
        .filter { string -> string.length == 6 }
        .forEach { println(it) }
    println("prime range --------------------------------")
    for (i in 1..100) {
        if(isPrime(i)){
            print("$i, ")
        }
    }
    println("msg coding --------------------------------")
    fun myCoding(msg:String):String{
        return msg
            .map { char -> (char+1).toChar() }
            .joinToString("")
    }
    fun myDeCoding(msg:String):String{
        return msg
            .map { char -> (char-1).toChar() }
            .joinToString("")
    }
    val msg = "Akos vagyok"
    println("message: $msg")
    println("encoded: ")
    messageCoding(msg, ::myCoding)
    println("decoded: ")
    messageCoding(msg, ::myDeCoding)
}
fun addWithStringFromat(number1:Int, number2:Int):Unit{
    println("$number1 + $number2 = ${number1+number2}")
}
fun isPrime(number:Int):Boolean{
    if (number < 2) return false

    for (i in 2..Math.sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}
fun messageCoding(msg: String, func: (String) -> String): String{
    return func(msg);
}