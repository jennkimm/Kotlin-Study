package ch07

data class NameComponents2 (
    val name: String,
    val extension: String
        )

fun splitFilename2(fullName: String) : NameComponents2 {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents2(name, extension)
}

fun main(args: Array<String>) {
    val (name, ext) = splitFilename2("example.kt") // 구조 분해 선언 구문을 사용해 데이터 클래스를 풂
    println(name) // example
    println(ext) // kt
}