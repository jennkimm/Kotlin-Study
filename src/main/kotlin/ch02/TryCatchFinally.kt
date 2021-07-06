package ch02

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch (e: NumberFormatException) { // 체크 예외 아님
        // 자바에서는 체크 예외를 명시적으로 처리해야 한다. ( catch 절 안에서 처리하거나 / throw 던지거나 )
        // 코틀린에서는 함수가 던지는 예외를 지정하지 않고, 예외를 잡아내지 않아도 상관없다.
        return null
    }
    finally {
        reader.close()
    }
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
}