package ch09

inline fun <reified T> isA(value: Any) = value is T

/* filterIsInstance 간단하게 정리한 코드
inline fun <reified T>
    Iterable<*>.filterIsInstance() : List<T> {
    val destination = mutableListOf<T>()
    for (element in this) {
        if (element is T) {
            destination.add(element)
        }
    }
    return destination
}

 */

fun main(args: Array<String>) {
    println(isA<String>("abc")) // true
    println(isA<String>(123)) // false


    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>()) // [one, three]
}