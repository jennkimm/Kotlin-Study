package ch04

open class User3 constructor(val nickname: String) {
    companion object {
        open fun newSubscribingUser(email: String)
                = User3(email.substringBefore('@'))
        fun newSubscribingUser2(email: String)
                = SubscribingUser()
    }
    fun newSubscribingUser3(email: String) : SubscribingUser {
        println("newSubscribingUser3")
        return SubscribingUser()
    }
}

class SubscribingUser() : User3("seohyun") {
}

fun main() {
    User3.newSubscribingUser2("@")
}