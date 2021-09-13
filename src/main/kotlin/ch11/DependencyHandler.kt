package ch11

class DependencyHandler {
    fun compile(coordinate: String) { // 일바적인 명령형 API를 정의
        println("Added dependency on $coordinate")
    }

    operator fun invoke(
        body: DependencyHandler. () -> Unit
    ) { // "invoke"를 정의해 DSL 스타일 API를 제공
        body() // "this"가 함수의 수신 객체가 되므로 this.body()와 같음
    }
}

fun main(args: Array<String>) {
    val dependencies = DependencyHandler()
    dependencies.compile("org.jetbrains.kotlin:kotlin-stdlib:1.0.0")
    dependencies {
        compile("org.jetbrains.kotlin:kotlin-reflect:1.0.0")
    }
}