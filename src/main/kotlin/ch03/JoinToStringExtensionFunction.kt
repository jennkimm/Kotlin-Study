package ch03

fun <T> Collection<T>.joinToString (
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0 ) result.append(separator) // 첫 원소 앞에 구분자 붙이기 않게
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join (
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))
    println(listOf("one", "two", "eight").join(" ")) // one two eight
    // listOf(1, 2, 8).join() : 오류. 객체의 리스트에 대해 호출할 수 x
}