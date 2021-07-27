package ch05

// SAM 생성자를 사용해 값 반환하기
fun createAllDoneRunnable() : Runnable {
    return Runnable { println("All done!") } // SAM 생성자
}

fun main(args: Array<String>) {
    // SAM 생성자를 사용해 값 반환하기
    createAllDoneRunnable().run() // All done!
}