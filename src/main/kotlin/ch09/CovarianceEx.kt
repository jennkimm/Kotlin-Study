package ch09

open class Animal {
    fun feed() { println("feed called") }
}

/*
class Herd<T : Animal> { // 이 타입 파라미터를 무공변성으로 지정
    val size: Int get() = ''
    operator fun get(i: Int) : T = ''
}*/

class Herd<out T : Animal>(vararg animals: T) { // T는 이제 공변적이다.
    val size: Int get() = TODO()
    operator fun get(i: Int) : T = TODO()
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

class Cat : Animal() {
    fun cleanLitter() {
        println("cleanLitter called")
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
        // feedAll(cats) 타입 불일치 오류 발생
    }
    feedAll(cats) // 캐스팅 할 필요가 없음
}

fun main(args: Array<String>) {
    // takeCareOfCats(Herd<Cat>(Cat()))
}