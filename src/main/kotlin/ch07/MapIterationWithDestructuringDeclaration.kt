package ch07

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) { // 루프 변수에 구조 분해 선언을 사용
        println("$key -> $value")
    }
}

fun main(args: Array<String>) {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
    // Oracle -> Java
    // JetBrains -> Kotlin
}