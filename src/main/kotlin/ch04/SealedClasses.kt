package ch04

interface Expr1 // 상위 클래스

class Num1(val value: Int) : Expr1 // 하위 클래스
class Sum1(val left: Expr1, val right: Expr1) : Expr1 // 하위 클래스

// 새로운 하위 클래스가 생겼을 때, when 이 새로운 클래스의 모든 경우를 처리하는지 제대로 검사할 수가 없음.
fun eval1(e: Expr1): Int =
    when (e) {
        is Num1 -> e.value
        is Sum1 -> eval1(e.right) + eval1(e.left)
        else -> // else 분기가 반드시 필요하다
            throw IllegalArgumentException("Unknown expression")
    }

fun main(args: Array<String>) {
    println(eval1(Sum1(Sum1(Num1(1), Num1(2)), Num1(4))))
}