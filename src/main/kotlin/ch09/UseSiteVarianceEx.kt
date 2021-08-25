package ch09

// 무공변 파라미터 타입을 사용하는 데이터 복사 함수
fun <T> copyData1 (source: MutableList<T>, destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}



// 타입 파라미터가 둘인 데이터 복사 함수
fun <T: R, R> copyData2(source: MutableList<T>, destination: MutableList<R>) { // source 원소 타입은 destination 원소 타입의 하위 타입이어야 함
    for (item in source) {
        destination.add(item)
    }
}


// 아웃-프로젝션 타입 파라미터를 사용하는 데이터 복사 함수
fun <T> copyData3(source: MutableList<out T>, destination: MutableList<T>) {
// out 키워드를 타입을 사용하는 위치 앞에 붙이면 in 위치에 사용하는 메소드를 호출하지 않는다는 뜻
    for (item in source) {
        destination.add(item)
    }
}

// in 프로젝션 타입 파라미터를 사용하는 데이터 복사 함수
fun <T> copyData4(source: MutableList<T>, destination: MutableList<in T>) {
    // 원본 리스트 원소 타입의 상위 타입을 대상 리스트 원소 타입으로 허용
    for (item in source) {
        destination.add(item)
    }
}

fun main(args: Array<String>) {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    copyData4(ints, anyItems) // Int가 Any의 하위 타입이므로 이 함수를 호출할 수 있음
    println(anyItems) // [1, 2, 3]


    val list: MutableList<out Number> = mutableListOf(1, 2, 3)
    //list.add(42) // 컴파일 오류
}