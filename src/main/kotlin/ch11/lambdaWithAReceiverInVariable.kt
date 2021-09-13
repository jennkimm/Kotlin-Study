package ch11

fun main(args: Array<String>)  {
    val appendExcl : StringBuilder. () -> Unit =
        { this.append("!") } // appendExcl은 확장 함수 타입의 값임

    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExcl() // appendExcl을 확장 함수처럼 호출할 수 있음
    println(stringBuilder) // Hi !
    println(buildString(appendExcl)) // appendExcl을 인자로 넘길 수 있음
}