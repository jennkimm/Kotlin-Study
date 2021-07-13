package ch03

open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

fun main(args: Array<String>) {
    val view: View = Button()
    view.click() // Button clicked

    val view2: View = Button()
    view2.showOff() // I'm a view! => 확장 함수는 정적으로 결정됨
}