package ch10

class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val person = Person("Alice", 29)
    val memberProperty = Person::age
    println(memberProperty.get(person))
}
