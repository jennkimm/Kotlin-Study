package ch05

data class Person(val name: String, val age: Int) // 사람의 이름과 나이를 저장하는 클래스

// 컬렉션을 직접 검색하기
fun findTheOldest(people: List<Person>) {
    var maxAge = 0 // 가장 많은 나이를 저장
    var theOldest: Person? = null // 가장 연장자인 사람을 저장
    for (person in people) {
        if (person.age > maxAge) { // 현재까지 발견한 최연장자보다 더 나이가 많은 사람 찾으면 최댓값 바꿈
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    // 컬렉션을 직접 검색
    findTheOldest(people) // Person(name=Bob, age=31)

    // 멤버 참조를 사용해 컬렉션 검색
    println(people.maxByOrNull(Person::age))

    // 람다를 사용해 컬렉션 검색
    println(people.maxByOrNull { it.age }) // 나이 프로퍼티를 비교해서 값이 가장 큰 원소 찾기

    // (1) 정식으로 람다 작성
    println(people.maxByOrNull({ p: Person -> p.age }))
    // (2)
    // 마지막에 있는 인자가 람다 식이므로 괄호 밖으로 빼냄
    println(people.maxByOrNull() { p: Person -> p.age })
    // (3)
    // 람다가 어떤 함수의 유일한 인자이고, 괄호 뒤에 람다를 썼다면 호출 시 빈 괄호 없애도 됨
    println(people.maxByOrNull { p: Person -> p.age })
    // (4)
    // 파라미터 타입을 생략(컴파일러가 추론)
    println(people.maxByOrNull { p -> p.age })
    // (5)
    // 디폴트 파라미터 이름 it 사용하기
    println(people.maxByOrNull { it.age })

    // (6) 람다를 변수에 저장할 때는 파라미터 타입 명시 필수(추론할 문맥 존재x)
    val getAge = {p: Person -> p.age }
    println(people.maxByOrNull(getAge))

    /*
    // 이름 붙인 인자를 사용해 람다 넘기기
    val people2 = listOf(Person("이몽룡", 29), Person("성춘향", 31))
    val names = people2.joinToString(separator = " ", transform = { p: Person -> p.name})
    println(names) // 이몽룡 성춘향
     */
}