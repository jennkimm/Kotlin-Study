package ch07

import java.math.BigDecimal

operator fun BigDecimal.inc () = this + BigDecimal.ONE // 증가 연산자 정의

fun main(args: Array<String>) {
    var bd = BigDecimal.ZERO
    println(bd++) // 0, 후위 증가 연산자는 println이 실행된 다음에 값을 증가시킴
    println(++bd) // 2, 전위 증가 연산자는 println이 실행되기 전에 값을 증가시킴
}