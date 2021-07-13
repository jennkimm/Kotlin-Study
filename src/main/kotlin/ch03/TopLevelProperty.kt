package ch03

var opCount = 0 // 최상위 프로퍼티 선언

fun performOperation() {
    opCount++ // 최상위 프로퍼티의 값을 변경
}

fun reportOperationCount() {
    println("Operation performed $opCount times") // 최상위 프로퍼티 값 읽음
}

fun main(args: Array<String>) {
    reportOperationCount() // Operation performed 0 times
    performOperation()
    reportOperationCount() // Operation performed 1 times
}