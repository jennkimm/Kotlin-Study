package ch05

fun alphabet () : String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) { // 메소드를 호출하려는 수신 객체를 지정
        for (letter in 'A'..'Z') {
            this.append(letter) // "this"를 명시해서 앞에서 지정한 수신 객체의 메소드를 호출
        }
        append("\nNow I know the alphabet!") // "this"를 생략하고 메소드를 호출
        this.toString() // 람다에서 값을 반환
    }
}

fun alphabet2()  = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

fun main(args: Array<String>) {
    println(alphabet())
    println(alphabet2())
}