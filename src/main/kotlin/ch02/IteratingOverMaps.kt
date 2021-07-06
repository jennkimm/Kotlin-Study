package ch02

import java.util.TreeMap

fun main(args: Array<String>) { // 키에 대해 정렬하기 위해
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary // c를 키로 c의 2진 표현을 맵에 넣는다
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}