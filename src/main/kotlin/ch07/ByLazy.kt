package ch07

class Email(val text: String)

class Person2(val name: String) {
    private var _emails: List<Email>? = null // 데이터를 저장하고 emails의 위임 객체 역할을 하는 _emails 프로퍼티
    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this) // 최초 접근 시 이메일을 가져온다.
            }
            return _emails!! // 저장해 둔 데이터가 있으면 그 데이터를 반환
        }
}

class Person3(val name: String) { // 지연 초기화를 위임 프로퍼티를 통해 구현하기
    val emails by lazy { loadEmails2(this) }
}

fun loadEmails(person: Person2) : List<Email> {
    println("${person.name}의 이메일을 가져옴")
    return listOf(Email(person.name))
}

fun loadEmails2(person: Person3) : List<Email> {
    println("${person.name}의 이메일을 가져옴")
    return listOf(Email(person.name))
}

fun main(args: Array<String>) {
    val p = Person2("Alice")
    println(p.emails)
    println(p.emails)

    val p2 = Person3("Bob")
    println(p2.emails)
    println(p2.emails)
}