package ch03

import strings.lastChar

fun main(args: Array<String>) {
    println("Kotlin".lastChar) // n

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb) // Kotlin!
}