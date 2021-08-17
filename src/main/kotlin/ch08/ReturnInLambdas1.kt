package ch08

data class Person4(val name: String, val age: Int)

val people4 = listOf(Person4("Alice", 29), Person4("Bob", 31))

fun lookForAlice(people: List<Person4>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun main(args: Array<String>) {
    lookForAlice(people4)
}