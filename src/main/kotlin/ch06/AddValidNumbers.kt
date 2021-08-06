package ch06

import java.io.BufferedReader
import java.io.StringReader
import java.util.ArrayList

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
//        try {
//            val number = line.toInt()
//            result.add(number)
//        }
//        catch(e: NumberFormatException) {
//            result.add(null)
//        }
        result.add(line.toIntOrNull()) // -> 이렇게도 가능
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    var invalidNumbers2 = numbers.filterNotNull() // 이렇게도 가능
    for (number in numbers) { // 리스트에서 널이 될 수 있는 값을 읽는다.
        if (number != null) {
            sumOfValidNumbers += number
        } else {
            invalidNumbers++
        }
    }
    println("Sum of valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)
}
