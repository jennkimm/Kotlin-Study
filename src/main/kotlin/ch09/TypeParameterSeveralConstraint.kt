package ch09

fun <T> ensureTrailingPeriod(seq: T)
    where T : CharSequence, T : Appendable { // 타입 파라미터 제약 목록
        if (!seq.endsWith('.')) { // CharSequence 인터페이스의 확장 함수를 호출
            seq.append('.') // Appendable 인터페이스의 메소드를 호출
        }
    }


fun main(args: Array<String>) {
    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld) // Hello World.
}