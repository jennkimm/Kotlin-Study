package ch05

fun alphabet4() = buildString {
    for(letter in 'A'..'Z') {
        append(letter)
    }

    append("\nNow I know the alphabet!")
}

fun main(args: Array<String>) {
    println(alphabet4())
}