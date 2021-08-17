package ch08

data class Person3(val name: String, val age: Int)

val people3 = listOf(Person3("Alice", 29), Person3("Bob", 31))

fun lookForAlice(people: List<Person3>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun main(args: Array<String>) {
    lookForAlice(people3)
}