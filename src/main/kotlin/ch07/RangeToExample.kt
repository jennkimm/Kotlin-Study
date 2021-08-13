package ch07

import java.time.LocalDate

fun main(args: Array<String>) {
    val now = LocalDate.now()
    val vacation = now..now.plusDays(10) // now(오늘)부터 시작해 10일짜리 범위를 만듦
    // => 컴파일러에 의해 now.rangeTo(now.plusDays(10))으로 변환됨 [Comparable에 대한 확장 함수]
    println(now.plusWeeks(1) in vacation) // true

    val n = 9
    println(0..(n + 1)) // 0..10 , 괄호를 쳐서 뜻이 명확하게 해줌
    (0..n).forEach { print(it) } // 012345679, 범위의 ㅔ소드를 호출하려면 범위를 괄호로 둘러싸야 함
}