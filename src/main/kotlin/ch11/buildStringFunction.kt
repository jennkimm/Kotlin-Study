package ch11

fun buildString(
    builderAction: (StringBuilder) -> Unit // 함수 타입인 파라미터를 정의
) : String {
    val sb = StringBuilder()
    builderAction(sb) // 람다 인자로 StringBuilder 인스턴스를 넘김
    return sb.toString()
}

fun main(args: Array<String>) {
    val s = buildString {
        it.append("Hello, ") // "it"은 StringBuilder 인스턴스를 가리킴
        it.append("World!")
    }
    println(s)
}