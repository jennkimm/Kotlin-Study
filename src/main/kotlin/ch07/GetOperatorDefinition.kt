package ch07

import java.lang.IndexOutOfBoundsException

operator fun Point.get(index: Int) : Int { // "get" 연산자 함수를 정의
    return when(index) { // 주어진 인덱스에 해당하는 좌표를 찾음
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun main(args: Array<String>) {
    val p = Point(10, 20)
    println(p[1]) // 20
}