package ch09

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int> // Unchecked cast 경고 발생
        ?: throw IllegalArgumentException("Array is expected")
    println(intList)
}

fun main(args: Array<String>) {
    printSum(listOf(1, 2, 3))
    printSum(setOf(1, 2, 3)) // IllegalArgumentException 예외 발생
    printSum(listOf("a", "b", "c")) // classCastException 발생
}

