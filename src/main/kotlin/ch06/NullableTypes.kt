package ch06

/* null이 인자로 들어올 수 없다면 */
/* s는 항상 String의 인스턴스여야 하고, null이 될 수 있는 값을 strLen에 넘기지 못한다.*/
fun strLen(s: String) = s.length

//fun strLenSafe(s: String?): Int = s.length // 컴파일 안됨 ( 널이 될 수 있는 타입인 변수에 변수.메소드() 호출 안됨 )

fun strLenSafe(s: String?): Int =
    if (s != null)
        s.length // null이 아님이 확실한 영역에서는 해당 값을 널이 될 수 없는 타입의 값처럼 사용가능
    else
        0

fun main(args: Array<String>) {
    val x: String? = null
    println(strLenSafe(x))
    println(strLenSafe("abc"))
}