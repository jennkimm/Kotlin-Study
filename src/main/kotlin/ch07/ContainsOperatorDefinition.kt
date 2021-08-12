package ch07

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point) : Boolean {
    return p.x in upperLeft.x until lowerRight.x && // 범위를 만들고 "x"좌표가 그 범위 안에 있는지 검사
            p.y in upperLeft.y until lowerRight.y // "until" 함수를 사용해 열린 범위를 만듦
}

fun main(args: Array<String>) {
    val rect = Rectangle(Point(10, 20), Point(50, 50))
    // in의 우항에 있는 객체는 contains 메소드의 수신 객체가 됨
    // in의 좌항에 있는 객체는 contains 메소드에 인자로 전달됨
    println(Point(20, 30) in rect) // true
    println(Point( 5, 5) in rect) // false
}