package ch09

fun main(args: Array<String>) {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2)) // 타입 인자를 명시적으로 지정
    println(letters.slice(10..13)) // 컴파일러는 여기서 T가 Char라는 사실을 추론


    val authors = listOf("Dmitry", "Svetlana")
    val readers = mutableListOf<String>("Dmitry", "AA", "CC")
    println(readers.filter { it !in authors }) // [AA, CC]
}
