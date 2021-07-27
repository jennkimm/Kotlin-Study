package ch05

data class Person2(val name: String, val age: Int)
class Book(val title: String, val authors: List<String>)

fun main(args: Array<String>) {
    //==== 5.2.1 filter와 map ====//
    val list = listOf(2, 3, 4, 5)
    println(list.filter { it % 2 == 0}) // 짝수만 남음 [2, 4]

    val people = listOf(Person2("Alice", 29), Person2("Bob", 31))
    println(people.filter{ it.age > 30 }) // [Person(name=Bob, age=31)]

    // 각 숫자의 제곱이 모인 리스트로 바꾸기
    val list2 = listOf(1, 2, 3, 4)
    println(list2.map {it * it}) // [1, 4, 9, 16]

    // 사람 리스트를 이름 리스트로 변환
    println(people.map { it.name })
    println(people.map(Person2::name)) // 멤버 참조를 사용

    // 호출 연쇄 시키기
    println(people.filter {it.age > 30}.map(Person2::name)) // [Bob]

    // 가장 나이 많은 사람의 이름 목록
    val maxAge = people.maxByOrNull(Person2::age)!!.age
    println(people.filter {it.age == maxAge }) // [Person2(name=Bob, age=31)]

    // 필터와 변환 함수 맵에 적용
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() }) // {0=ZERO, 1=ONE}




    //==== 5.2.2 all, any, count, find ====//
    val canBeInClub27 = { p: Person2 -> p.age <= 27 } // 어떤 사람의 나이가 27살 이하인지 판단하는 함수
    val people2 = listOf(Person2("Alice", 27), Person2("Bob", 31))

    // (1) all 함수 : 모든 원소가 술어를 만족하는지 판단
    println(people2.all(canBeInClub27)) // false
    // (2) any 함수 : 술어를 만족하는 원소가 하나라도 있는지 판단
    println(people2.any(canBeInClub27)) // true
    // (3) count 함수 : 술어를 만족하는 원소의 개수 구함
    println(people2.count(canBeInClub27)) // 1
    // (4) find 함수 : 술어를 만족하는 원소 하나 찾기 == firstOfNull과 같음
    println(people2.find(canBeInClub27)) // Person2(name=Alice, age=27)




    //==== 5.2.3 groupBy ====//
    val people3 = listOf(Person2("Alice", 31), Person2("Bob", 29), Person2("Carol", 31))
    println(people3.groupBy {it.age}) // {31=[Person2(name=Alice, age=31), Person2(name=Carol, age=31)], 29=[Person2(name=Bob, age=29)]}

    // 멤버 참조를 활용해 문자열을 첫 글자에 따라 분류
    val list3 = listOf("a", "ab", "b")
    println(list3.groupBy(String::first)) // String의 확장 함수 first
    // 결과 : {a=[a, ab], b=[b]}




    //==== 5.2.4 flatMap과 flatten ====//
    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() }) // [a, b, c, d, e, f]

    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")))
    println(books.flatMap { it.authors }.toSet()) // [Jasper Fforde, Terry Pratchett, Neil Gaiman]
    // 특별히 변환해야 할 내용이 없다면 flatten() 사용 ex) listOfLists.flatten()
}