package ch09

import kotlin.String

fun <T : Number> oneHalf(value: T) : Double { // Number를 타입 파라미터 상한으로 정함
    return value.toDouble() / 2.0 // Number 클래스에 정의된 메소드를 호출함
}

// 타입 파라미터를 제약하는 함수 선언하기
fun <T: Comparable<T>> max(first: T, second: T) : T { // 이 함수의 인자들은 비교 가능해야 함
    return if(first > second) first else second
}

fun main(args: Array<String>) {
    println(oneHalf(3)) // 1.5


    // 문자열은 알파벳순으로 비교됨
    println(max("kotlin", "java")) // kotlin
    // println(max("kotlin", 42)) 컴파일 오류
}