package strings

fun String.lastChar() : Char = this.get(this.length - 1)

// 수신 객체 멤버에 this 없이 접근 가능
/*
fun String.lastChar() : Char = get(length - 1)
 */

// 확장 프로퍼티 선언
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1) // 프로퍼티 게터
    set(value: Char) {
        this.setCharAt(length - 1, value) // 프로퍼티 세터
    }