package ch03

fun main(args: Array<String>) {
    // 1. 정규식을 명시적으로 만들어서 분리
    // toRegex 확장 함수 : 문자열을 정규식으로 변환
    println("12.345-6.A".split("\\.|-".toRegex())) // [12, 345, 6, A]

    // 2. split 확장 함수 오버로딩한 버전 사용하기
    // 여러 구분 문자열을 지정
    println("12.345-6.A".split(".", "-")) // [12, 345, 6, A]

}