package ch08

fun <T> Collection<T>.nullableJoinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        val str = transform?.invoke(element) // 안전 호출 사용
            ?: element.toString() // null 반환 시 toString() 연산자 호출
        result.append(str)
    }

    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    val letters = listOf("Alpha", "Beta")
    println(letters.nullableJoinToString())
    println(letters.nullableJoinToString { it.toLowerCase() })
    println(letters.nullableJoinToString(separator = "! ", postfix = "! ",
        transform = { it.toUpperCase() }))
}