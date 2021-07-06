package ch02

interface Expr
class Num(val value: Int) : Expr // 값 반환 / value라는 프로퍼티만 존재하는 단순한 클래스로 Expr 구현
class Sum(val left: Expr, val right: Expr) : Expr // 좌항과 우항을 더해서 그 두 값을 합해서 반환

fun eval(e: Expr): Int =
    if (e is Num) { // 변수 타입 검사
        e.value // 스마트캐스트
    } else if (e is Sum) {
        eval(e.right) + eval(e.left) // 스마트캐스트
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}