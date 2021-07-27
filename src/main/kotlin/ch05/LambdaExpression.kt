package ch05

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2)) // 변수에 저장된 람다를 호출

    run {println(42)} // 람다 본문에 있는 코드를 실행, run: 인자로 받은 람다를 실행해주는 라이브러리 함수


    // 여러줄로 이루어진 람다 - 본문의 맨 마지막에 있는 식이 결과 값이 됨
    val sum2 = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum2(1, 2))
    // Computing the sum of 1 and 2...
    // 3
}