package ch09

class Processor<T: Any> { // "null"이 될 수 없는 타입 상한을 지정
    fun process(value: T) {
        value.hashCode() // T 타입의 "value"는 "null"이 될 수 없음
    }
}

fun main(args: Array<String>) {
    val notNullStringProcessor = Processor<String>()
    // notNullStringProcessor.process(null) 컴파일 오류
}