package ch07

operator fun Char.times(count: Int) : String { // 결과 타입이 피연산자 타입과 다른 연산자 정의
    return toString().repeat(count)
}

fun main(args: Array<String>) {
    println('a' * 3) // aaa
}