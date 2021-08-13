package ch07

/* 값을 맵에 저장하는 프로퍼티 정의하기
class Person7 {
    // 추가 정보
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    // 필수 정보
    val name: String
    get() = _attributes["name"]!! // 수동으로 맵에서 정보를 꺼냄
}
 */

// 값을 맵에 저장하는 위임 프로퍼티 사용
class Person7 {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String by _attributes // 위임 프로퍼티로 맵을 사용
}

fun main(args: Array<String>) {
    val p = Person7()
    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
    for ((attrName, value) in data)
        p.setAttribute(attrName, value)
    println(p.name) // Dmitry
}