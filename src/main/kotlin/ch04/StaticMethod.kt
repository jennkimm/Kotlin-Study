package ch04

fun String.lastChar() : Char = get(this.length - 1)

fun main() {
    val s :String = "this"

    s.lastChar()
}