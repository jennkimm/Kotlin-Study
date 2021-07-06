package ch02

import ch02.Color.*

fun mix(c1: Color, c2: Color) =
    when(setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE // 두 색을 혼합해서 다른 색을 만들 수 있는 경우를 열거
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color") // 매치되는 분기 조건이 없으면 이 문장 실행
    }

fun mixOptimized(c1: Color, c2: Color) = // 인자가 없는 when. 조건이 불리언식. 불필요한 객체 생성을 막을 수 있음
    when {
        (c1 == RED && c2 == YELLOW) ||
                (c1 == YELLOW && c2 == RED) ->
            ORANGE
        (c1 == YELLOW && c2 == BLUE) ||
                (c1 == BLUE && c2 == YELLOW) ->
            GREEN
        (c1 == BLUE && c2 == VIOLET) ||
                (c1 == VIOLET && c2 == BLUE) ->
            INDIGO
        else -> throw Exception("Dirty color")
    }

fun main(args: Array<String>) {
    println(mix(BLUE, YELLOW))
}