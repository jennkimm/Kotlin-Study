package ch06

fun array1() {
    // 람다는 배열의 원소의 인덱스를 인자로 받아서 배열의 해당 위치에 들어갈 원소를 반환
    val letters = Array<String>(26) { i -> ('a' + i).toString() }
    println(letters.joinToString(""))
}

fun array2() {
    val strings = listOf("a", "b", "c")
    // 배열을 인자로 받는 자바 함수를 호풀하거나 vararg 파라미터를 받는 코틀린 함수를 호출하기 위해 배열을 만든다.
    // 데이터가 이미 컬렉션에 들어있다면, 배열로 변환해야 한다. -> toTypedArray() 사용
    println("%s/%s/%s".format(*strings.toTypedArray())) // vararg 인자를 넘기기 위해 스프레드 연산자(*)를 써야 한다.
}

fun array3() {
    /*
    배열 타입의 타입 인자도 항상 객체 타입이 되서, Array<Int> 를 선언하면 박싱된 정수의 배열로 된다.
    원시 타입의 배열이 필요하다면 특별한 배열 클래스를 써야한다.
    Int 타입의 경우에는 IntArray.
    코틀린은 ByteArray, CharArray, BooleanArray 등 다양하게 제공
    각각 byte[], char[], bool[] 등으로 컴파일
    */
    val squares = IntArray(5) { i -> (i+1) * (i+1) }
    println(squares.joinToString())
}

fun main(args: Array<String>) {
    args.forEachIndexed { index, element ->
        println("Argument $index is: $element")
    }
    val strings = arrayOf("a", "b", "c", 1, 3)
    val test = strings.filter{ it is String } // 리스트 타입
}
