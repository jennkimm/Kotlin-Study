package ch04

interface Clickable2 {
    fun click()
    fun showOff() = println("I'm clickable!")
}

open class RichButton : Clickable2 {
    override fun click() {} // 오버라이드한 메소드는 기본적으로 열려있다.
    open fun animate() {} // 하위 클래스에서 오버라이드 가능
    fun disable() {} // final
}
