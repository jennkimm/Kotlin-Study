package ch05

import java.io.File

// 상위 디렉터리의 시퀀스를 생성하고 사용
fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }

fun main(args: Array<String>)  {
    // 자연수의 시퀀스를 생성하고 사용
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum()) // 모든 지연 연산은 "sum"의 결과를 계산할 때 수행


    // 상위 디렉터리의 시퀀스를 생성하고 사용
    val file = File("/Users/svtk/.HiddenDir/a.txt")
    println(file.isInsideHiddenDirectory()) // true
}