package ch07

// Point.kt 파일
// data class Point(val x: Int, val y: Int)

operator fun Point.plus(other: Point) : Point { // 연산자를 확장 함수로 정의
    return Point(x + other.x, y + other.y)
}

fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2) // Point2(x=40, y=60)
}