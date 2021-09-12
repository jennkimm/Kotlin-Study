package ch10

import kotlin.reflect.KFunction2

fun sum(x: Int, y: Int) = x + y

fun main(args: Array<String>) {
    val kFunction2: KFunction2<Int, Int, Int> = ::sum
    println(kFunction2(1, 2))
}
