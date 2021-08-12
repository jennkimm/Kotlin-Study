package ch07

fun main(args: Array<String>) {
    val list = arrayListOf(1, 2)
    list += 3 // +=는 "list"를 변경
    val newList = list + listOf(4, 5) // +는 두 리스트의 모든 원소를 포함하는 새로운 리스트를 반환
    println(list) // [1, 2, 3]
    println(newList) // [1, 2, 3, 4, 5]
}