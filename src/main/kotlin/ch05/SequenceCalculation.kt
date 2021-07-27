package ch05

fun main(args: Array<String>) {
    listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0}
        .toList() // 최종 연산
    // 결과 : map(1) filter(1) map(2) filter(4) map(3) filter(9) map(4) filter(16)

    println(listOf(1, 2, 3, 4).asSequence()
        .map { it * it }.find { it> 3}) // 4



    val people = listOf(Person("Alice", 29), Person("Bob", 31), Person("Charles", 31), Person("Dan", 21))

    // map 다음에 filter 수정
    println(people.asSequence().map(Person::name).filter { it.length < 4 }.toList()) // [Bob, Dan]
    // filter 다음에 map 수정
    println(people.asSequence().filter { it.name.length < 4}.map(Person::name).toList()) // [Bob, Dan]
}