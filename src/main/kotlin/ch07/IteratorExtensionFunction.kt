package ch07

//operator fun CharSequence.iterator() : CharIterator
// => 이 라이브러리 함수는 문자열을 이터레이션할 수 있게 해줌

fun main(args: Array<String>) {
    for (c in "abc") {
        println(c)
    }
}