package ch07

// Point.kt 파일
// data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() : Point { // 단항 minus 함수는 파라미터가 x
    return Point(-x, -y) // 좌표에서 각 성분의 음수를 취한 새 점을 반환
}

fun main(args: Array<String>) {
    val p = Point(10, 20)
    println(-p) // Point(x=-10, y=-20)
}