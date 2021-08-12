package ch07

import java.lang.IndexOutOfBoundsException

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) { // "set"이라는 연산자 함수를 정의
    when(index) { // 주어진 인덱스에 해당하는 좌표를 변경
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun main(args: Array<String>) {
    val p = MutablePoint(10, 20)
    p[1] = 42
    println(p) // MutablePoint(x=10, y=42)
}