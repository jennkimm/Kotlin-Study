package ch03

fun main(args: Array<String>) {
    val set = hashSetOf(1, 7, 53); // 숫자로 이루어진 집합
    val list = arrayListOf(1, 7, 53); // 리스트
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three") // 맵

    println(set.javaClass) // javaClass = getClass()
    println(list.javaClass)
    println(map.javaClass)
}