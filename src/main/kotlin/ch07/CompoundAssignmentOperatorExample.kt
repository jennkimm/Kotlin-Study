package ch07

// Point.kt 파일
// data class Point(val x: Int, val y: Int)

fun main(args: Array<String>) {
    var point = Point(1, 2)
    point += Point(3, 4)
    println(point) // Point(x=4, y=6)
}