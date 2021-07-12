package ch03

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException (
                "Can't save user ${user.id} : $fieldName" // user.id 바깥 함수의 파라미터에 직접 접근
            )
        }
    }

    /*
    if (user.name.isEmpty()) {
        throw IllegalArgumentException (
            "Can't save user ${user.id} : empty Name"
                )
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException (
            "Can't save user ${user.id} : empty Address"
        )
    }
    */

    // 로컬 함수를 호출해서 각 필드를 검증한다.
    validate(user.name, "Name")
    validate(user.address, "Address")

    // user를 데이터베이스에 저장한다.
}

fun main(args: Array<String>) {
    saveUser(User(1, "", ""))
}