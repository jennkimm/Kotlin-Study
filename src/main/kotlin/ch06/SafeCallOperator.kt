package ch06

class Address(val streetAddress: String, val zipCode: Int,
              val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName() = company?.address?.country ?: "Unknown"

fun printShippingLabel(person: Person) {
    val address = person.company?.address
        ?: throw IllegalArgumentException("No address") // 주소가 없으면 예외 발생
    with (address) { // address는 null 이 아님
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun main(args: Array<String>) {
    val address = Address("Elsestr. 47", 80687, "Seoul", "Korea")
    val company = Company("SKKU", address)
    val person = Person("Dmitry", company)
    println(person.countryName())
    printShippingLabel(person)
}