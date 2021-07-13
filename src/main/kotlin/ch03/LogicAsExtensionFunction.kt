package ch03

class User2(val id: Int, val name: String, val address: String)

fun User2.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException (
                "Can't save user $id : empty $fieldName" // User의 프로퍼티 직접 사용
            )
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser2(user: User2) {
    user.validateBeforeSave() // 확장 함수를 호출

    // user를 데이터베이스에 저장한다.
}

fun main(args: Array<String>) {
    saveUser2(User2(1, "", ""))
}