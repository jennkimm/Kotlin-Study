package ch08

data class Person6(val name: String, val age: Int)

val people6 = listOf(Person6("Alice", 29), Person6("Bob", 31))

fun lookForAlice(people: List<Person6>) {
    people.forEach(fun (person) { // 람다 식 대신 무명함수 사용. 함수 이름, 파라미터 생략 가능
        if (person.name == "Alice")
            return // 가장 가까운 함수를 가리킴
        println("${person.name} is not Alice")
    })
}

fun main(args: Array<String>) {
    lookForAlice(people6)

    // filter에 무명함수 넘기기
    people6.filter (fun(person6) : Boolean {
        return person6.age < 30
    })
    // 식이 본문인 무명함수
    people6.filter(fun (person6) = person6.age < 30)
}