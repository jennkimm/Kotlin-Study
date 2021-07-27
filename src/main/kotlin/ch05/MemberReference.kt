package ch05

// 최상위 함수
fun salute() = println("Salute!")

fun sendEmail(person: Person, message: String) = println("sendEmail")

fun Person.isAdult() = age >= 21 // 확장 함수

fun main(args: Array<String>) {
    run(::salute) // 최상위 함수 참조

    // 작업을 위임하는 함수에 대한 참조
    val action = { person: Person, message: String -> sendEmail(person, message)} // 람다로 위임
    val nextAction = ::sendEmail // 람다 대신 멤버 참조 사용

    // 생성자 참조 -> 클래스 생성 작업 연기, 저장
    val createPerson = ::Person // "Person"의 인스턴스를 만드는 동작을 값으로 저장
    val p = createPerson("Alice", 29)
    println(p) // Person(name=Alice, age=29)

    // 확장 함수 참조
    val predicate = Person::isAdult
    println(predicate(p)) // true
}