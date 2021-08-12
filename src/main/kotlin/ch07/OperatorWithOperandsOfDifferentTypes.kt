package ch07

// Point.kt 파일
// data class Point(val x: Int, val y: Int)

operator fun Point.times(scale: Double) : Point { // 두 피연산자의 타입이 다른 연산자 정의
    return Point((x * scale).toInt(), (y * scale).toInt())
}

fun main(args: Array<String>) {
    val p = Point(10, 20)
    println(p * 1.5) // Point(x=15, y=30)
}