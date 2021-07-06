package ch02

class Person(
    val name: String, // 읽기 전용 프로퍼티
    var isMarried: Boolean // 쓸 수 있는 프로퍼티
)

fun main(args: Array<String>) {
    val person = Person("Bob", true)
    person.isMarried = false
    println(person.name)
    println(person.isMarried)
}
