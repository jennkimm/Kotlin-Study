package ch07

import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> =
    object : Iterator<LocalDate> { // 이 객체는 LocalDate 원소에 대한 Iterator를 구현
        var current = start

        override fun hasNext() = current <= endInclusive // compareTo 관례를 사용해 날짜 비교
        override fun next() = current.apply { // 현재 날짜를 저장한 다음에 날짜를 변경하고 저장해둔 날짜를 반환
            current = plusDays(1) // 현재 날짜를 1일 뒤로 변경
        }
    }

fun main(args: Array<String>)  {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) { println(dayOff) } // daysOff에 대응하는 iterator함수가 있으면 daysOff에 대해 이터레이션함
    // 2016-12-31
    // 2017-01-01
}