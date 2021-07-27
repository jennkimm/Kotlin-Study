package ch05

// 함수 파라미터를 람다 안에서 사용
fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach { // 각원소에 대해 수행할 작업을 람다로 받음
        println("$prefix $it") // 람다 안에서 함수의 "prefix"파라미터 사용
    }
}

// 람다 안에서 바깥 함수의 로컬 변수 변경하기
fun printProblemCounts (responses: Collection<String>) {
    // 람다에서 사용할 변수 정의
    var clientErrors = 0
    var serverErrors = 0

    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++ // 람다 안에서 람다 밖의 변수 변경(포획한 변수)
        } else if (it.startsWith("5")) {
            serverErrors++ // 람다 안에서 람다 밖의 변수 변경(포획한 변수)
        }
    }

    println("$clientErrors client erros, $serverErrors server errors")
}

fun main(args: Array<String>) {
    // (1) 람다 안에서 함수 파라미터 사용
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(errors, "Error:")
    // 결과
    // Error: 403 Forbidden
    // Error: 404 Not Found



    // (2)람다 안에서 바깥 함수의 로컬 함수 변경
    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses) // 1 client erros, 1 server errors
}