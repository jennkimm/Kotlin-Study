package ch04

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

fun getFacebookName(accountId: Int) = "fb:$accountId"

class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) =
            User(getFacebookName(accountId))
    }
}

fun main(args: Array<String>) {
    A.bar()

    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser.nickname)
}