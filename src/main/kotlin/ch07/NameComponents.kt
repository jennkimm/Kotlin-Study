package ch07

data class NameComponents(val name: String, val extension: String) // 값을 저장하기 위한 데이터 클래스 선언

fun splitFilename(fullName: String) : NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1]) // 함수에서 데이터 클래스의 인스턴스를 반환
}

fun main(args: Array<String>) {
    val (name, ext) = splitFilename("example.kt") // 구조 분해 선언 구문을 사용해 데이터 클래스를 풂
    println(name) // example
    println(ext) // kt
}