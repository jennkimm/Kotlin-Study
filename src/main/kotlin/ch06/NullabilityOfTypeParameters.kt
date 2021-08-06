package ch06

fun <T> printHashCode(t: T) {
    println(t?.hashCode()) // t가 null이 될 수 있으므로 안전한 호출 사용해야 한다.
}

fun <T: Any> printHashCode2(t: T) { // 타입 상한 지정 -> 널이 될 수 있는 값을 거부
    println(t.hashCode())
}

fun main(args: Array<String>) {
    printHashCode(null) // t의 타입은 Any?로 추론
}