package ch07

class Point3(val x: Int, val y: Int) {
    override fun equals(obj: Any?) : Boolean { // Any에 정의된 메소드를 오버라이딩
        if (obj === this) return true // 파라미터가 "this"와 같은 객체인지 살펴봄
        if (obj !is Point3) return false // 파라미터 타입을 검사
        return obj.x == x && obj.y == y // Point로 스마트 캐스트해서 x와 y 프로퍼티에 접근
    }
}

fun main(args: Array<String>) {
    println(Point3(10, 20) == Point3(10, 20)) // true
    println(Point3(10, 20) != Point3(5, 5)) // true
    println(null == Point3(1, 2)) // false
}