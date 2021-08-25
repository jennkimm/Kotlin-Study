package ch09

interface List<T> {  // List 인터페이스에 T라는 타입 파라미터를 정의함
    operator fun get(index: Int) : T // 인터페이스 안에서 T를 일반 타입처럼 사용가능
}

class StringList: List<String> { // 이 클래스는 구체적인 타입 인자로 String을 지정해 List를 구현함
    override fun get(index: Int) : String = this[index]
}

class ArrayList<A> : List<A> { // ArrayList의 제네릭 타입 파라미터 T를 List의 타입 인자로 넘김
    override fun get(index: Int) : A = this[index]
}


/*
interface Comparable<T> {
    fun compareTo(other: T) : Int
}

class String : Comparable<String> {
    override fun compareTo(other: String) : Int {
        return if (this === other) 1
        else 0
    }
}*/