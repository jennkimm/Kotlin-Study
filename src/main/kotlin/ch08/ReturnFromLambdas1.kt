package ch08

data class Person5(val name: String, val age: Int)

val people5 = listOf(Person5("Alice", 29), Person5("Bob", 31))

fun lookForAlice(people: List<Person5>) {
    people.forEach label@{
        if (it.name == "Alice") return@label
    }
    println("Alice might be somewhere")
}

fun main(args: Array<String>) {
    lookForAlice(people5)
}