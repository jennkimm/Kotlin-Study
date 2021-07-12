package ch03

fun <T> joinToString (
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0 ) result.append(separator) // 첫 원소 앞에 구분자 붙이기 않게
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    println(joinToString(list, separator = "; ", prefix = "(", postfix = ")")) // (1; 2; 3)
    println(joinToString(list, ", ", "", "")) // 1, 2, 3
    println(joinToString(list)) // 1, 2, 3
    println(joinToString(list, "; ")) // 1; 2; 3
    println(joinToString(list, postfix = ";", prefix = "# ")) // # 1, 2, 3;
}