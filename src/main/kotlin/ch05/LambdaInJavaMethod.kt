package ch05

/* 자바
void postponeComputation(int delay, Runnable computation);
*/

// object 선언을 사용하면서 람다와 동일한 코드 예시를 위함
val runnable = Runnable { println(42) } // 전역 변수로 컴파일 -> 프로그램 안에 단 하나의 인스턴스만 존재
fun handleComputation() {
    postponeComputation(1000, runnable) // 모든 handleCompuation 호출에 같은 객체를 사용
}

// 주변 영역의 변수를 포획한 람다 -> 인스턴스를 매번 새로 만들어 사용
fun handleComputation2(id: String) { // 람다 안에서 "id" 변수 포획
    postponeComputation(1000) { println(id) } // 이 함수를 호출할 때 마다 새로 Runnable 인스턴스 만듦
}

fun postponeComputation(delay: Int, computation: Runnable) {}

fun main(args: Array<String>) {
    postponeComputation(1000) { println(42) } // 컴파일러가 자동으로 람다를 Runnable 인스턴스로 변환
    handleComputation()

    // 객체 식을 함수형 인터페이스 구현으로 넘기기
    postponeComputation(1000, object: Runnable { // 메소드를 호출할 때 마다 새로운 객체가 생성됨
        override fun run() {
            println(42)
        }
    })
    handleComputation2("minseo") // 메소드를 호출할 때 마다 새로운 Runnable 인스턴스 생성됨

}