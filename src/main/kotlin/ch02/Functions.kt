package ch02

fun max_v1(a: Int, b: Int): Int { // 블록이 본문인 함수
    return if (a > b) a else b
}

fun max_v2(a: Int, b: Int): Int = // 반환 타입 생략 가능 (타입 추론)
    if (a > b) a else b // 식이 본문인 함수

fun main(args: Array<String>) {
    println(max_v1(1, 100))
    println(max_v2(1, 100))
}