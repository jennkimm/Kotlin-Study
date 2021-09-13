package ch11

class Greeter(val greeting: String) {
    operator fun invoke(name: String) { // Greeter 안에 "invoke" 메소드를 정의
        println("$greeting, $name!")
    }
}

fun main(args: Array<String>) {
    val bavarianGreeter = Greeter("Servus")
    bavarianGreeter("Dmitry") // Greeter 인스턴스를 함수처럼 호출함
}