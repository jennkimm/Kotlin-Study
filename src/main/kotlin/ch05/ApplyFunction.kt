package ch05

fun alphabet3() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }

    append("\nMow I know the alphabet!")
}.toString()

fun main(args: Array<String>) {
    println(alphabet3())
}