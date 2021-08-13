package ch07

private data class Point2(val x: Int, val y: Int) {
    operator fun plus(other: Point2): Point2 { // plus 연산자 함수 정의
        return Point2(x + other.x, y + other.y) // 좌표를 성분별로 더한 새로운 점을 반환
    }
}

fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2) // Point(x=40, y=60)
}