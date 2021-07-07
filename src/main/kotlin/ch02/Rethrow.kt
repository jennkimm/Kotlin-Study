package ch02

import java.io.BufferedReader
import java.io.StringReader

fun readNumber2(reader: BufferedReader) {
    try {
        val line = reader.readLine()
        Integer.parseInt(line)
    }
    catch (e: NumberFormatException) {
        println("$e not handled yet")
        throw e;
    }
    finally {
        reader.close()
    }
}

fun main(args: Array<String>) {
    val result = try {
        readNumber2(BufferedReader(StringReader("zz")))
    }
    catch(e: NumberFormatException) {
        null
    }
    println("result is $result")
}