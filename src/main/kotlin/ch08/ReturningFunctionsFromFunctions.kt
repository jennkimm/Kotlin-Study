package ch08

data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContactListFilters {
    var prefix: String = "" // 입력창에 입력된 문자열과 매치되는 연락처만 화면에 표시
    var onlyWithPhoneNumber: Boolean = false // 전화번호 정보가 없는 연락처 제외 가능

    fun getPredicate(): (Person) -> Boolean { // 연락처 목록을 필터링하는 술어 함수
        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) { //
            return startsWithPrefix
        }
        return { startsWithPrefix(it)
                && it.phoneNumber != null }
    }
}

fun main(args: Array<String>) {
    val contacts = listOf(Person("Dmitry", "Jemerov", "123-4567"),
        Person("Svetlana", "Isakova", null))
    val contactListFilters = ContactListFilters()
    with (contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(
        contactListFilters.getPredicate())) // getPredicate()가 반환한 함수를 filter 에게 인자로 넘긴다.
}