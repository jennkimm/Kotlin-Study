package ch11

fun buildString2(
    builderAction: StringBuilder. () -> Unit // 수신 객체가 있는 함수 타입의 파라미터를 선언
) : String {
    val sb = StringBuilder()
    sb.builderAction() // StringBuilder 인스턴스를 람다의 수신 객체로 넘김
    return sb.toString()
}

fun main(args: Array<String>) {
    val s = buildString2 {
        this.append("Hello, ") // "this" 키워드는 StringBuilder 인스턴스를 가리킴
        append("World!") // "this"를 생략해도 묵시적으로 StringBuilder 인스턴스가 수신 객체로 취급됨
    }

    println(s)
}