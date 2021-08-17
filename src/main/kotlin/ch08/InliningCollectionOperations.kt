package ch08

data class Person2(val name: String, val age: Int)

val people = listOf(Person2("Alice", 29), Person2("Bob", 31))

fun main(args: Array<String>) {
    // 컬렉션 크기가 큰 경우 -> 시퀀스를 사용해서 지연 계산
    // 컬렉션 크기가 작은 경우 -> 일반 컬렉션 연산이 나을 수도 (시퀀스는 람다가 인라이닝되지 않는다)
    println(people.filter { it.age < 30 }) // filter 는 인라인 함수
}