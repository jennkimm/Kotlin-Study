package ch09

import java.util.*

fun main(args: Array<String>) {
    val list: MutableList<Any?> = mutableListOf('a', 1, "qwe")
    val chars = mutableListOf('a', 'b', 'c')
    val unknownElements: MutableList<*> =
        if (Random().nextBoolean()) list else chars
    //unknownElements.add(42) // 컴파일 오류
    println(unknownElements.first()) // 원소를 가져와도 안전, first()는 Any? 타입의 원소를 반환함 , a
}