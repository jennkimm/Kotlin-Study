package ch10

import kotlin.reflect.KFunction1

fun foo(x: Int) = println(x)

fun main(args: Array<String>) {
    val kFunction : KFunction1<Int, Unit> = ::foo
    kFunction(42)
    // 왜 KCallable.call 메소드는 호출할수가 없는 거죠...?
    // 여기 이해 안가..
}
