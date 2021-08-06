package ch05

fun main() {
    listOf(1, 2, 3, 4).asSequence()
        .map { it * it }
        .find { it > 3 }
}