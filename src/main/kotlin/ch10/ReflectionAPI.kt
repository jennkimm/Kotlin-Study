package ch10

class Person11(val name: String, val age: Int)

fun main(args: Array<String>) {
    val person = Person11("Alice", 29)
    val kClass = person.javaClass.kotlin // 코틀린 클래스에 대한 참조. 자바 클래스를 얻고, 자바에서 코틀린 리플렉션 API로 옮겨
    println(kClass.simpleName)
    kClass.members.forEach { println(it.name) } // 클래스와 모든 조상 클래스 내부에 정의된 비확장 프로퍼티를 모두 가져옴
}
