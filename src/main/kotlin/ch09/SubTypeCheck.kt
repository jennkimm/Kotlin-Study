package ch09

fun test(i: Int) {
    val n: Number = i // Int가 Number의 하위 타입이어서 컴파일 됨

    fun f(s: String) {
        println(s)
    }
    // f(i) // Int가 String의 하위 타입이 아니어서 컴파일 되지 x
    f(n.toString())
}

fun main(args: Array<String>) {
    test(1)
}