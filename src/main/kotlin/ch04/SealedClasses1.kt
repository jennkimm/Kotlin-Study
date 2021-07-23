package ch04

sealed class Expr { // 기반 클래스. 하위 클래스 정의 제한 가능.
    class Num(val value: Int) : Expr() // 중첩 클래스
    class Sum(val left: Expr, val right: Expr) : Expr() // 중첩 클래스
}

// 나중에 새로운 하위클래스가 추가되면, 컴파일 에러가 나므로 when 식을 고쳐야하는 것을 알 수 있음.
fun eval(e: Expr): Int =
    when (e) { // When 식에서 모든 하위 클래스 검사 -> else 필요없음
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
    }

fun main(args: Array<String>) {
    println(eval(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4))))
}