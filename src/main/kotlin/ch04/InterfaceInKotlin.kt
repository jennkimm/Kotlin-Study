package ch04

interface Clickable { // 추상 메소드, 구현이 있는 메소드 정의 가능. 필드는 들어갈 수 없다.
    fun click() // 추상 메소드
    fun showOff() = println("I'm clickable!") // 디폴트 구현
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!") // showOff 메소드 디폴트 구현
}

class Button : Clickable { // 클래스는 오직 하나만 확장 가능. 인터페이스는 무제한 구현 가능.
    override fun click() = println("I was clicked") // 인터페이스 구현
}

class Button2 : Clickable, Focusable { // 두 개의 인터페이스 구현하는 클래스
    override fun click() = println("I was clicked")

    override fun showOff() {
        super<Clickable>.showOff() //상위 타입 구현 호출 시 super 키워드 사용, 꺾쇠 안에 기반 타입을 지정
        super<Focusable>.showOff()
    }
}

fun main(args: Array<String>) {
    val button = Button2()
    button.showOff()
    button.setFocus(true) // setFocus 함수는 구현을 자동으로 상속한다.
    button.click()
}