package ch11

import kotlinx.html.TD
import kotlinx.html.TR

open class Tag

class TABLE : Tag() {
    fun tr(init : TR.() -> Unit){} // tr 함수는 TR 타입을 수신 객체로 받는 람다를 인자로 받음
}

class TR : Tag() {
    fun td(init : TD. () -> Unit){} // td 함수는 TD 타입을 수신 객체로 받는 람다를 인자로 받음
}

class TD : Tag()