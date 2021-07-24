package ch04

interface User {
    val nickname: String // 추상 프로퍼티
}

class PrivateUser(override val nickname: String) : User

class SubscribingUser2(val email: String) : User {
    override val nickname: String // 뒷받침필드에 저장하지 않고 매번 이메일 주소에서 별명을 계산해 반환한다.
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : User {
    override val nickname = getFacebookName(accountId) // 객체를 초기화하는 단계에 한번만 호출
}

fun getFacebookName(id: Int) : String{
    return "string"
}

fun main() {

}