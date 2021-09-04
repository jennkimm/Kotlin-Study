package ch09

import java.util.*
import javax.xml.ws.Service

inline fun <reified T> loadService(): ServiceLoader<T>? {
    return ServiceLoader.load(T::class.java)
}

fun main(args: Array<String>) {
    // val serviceImpl = ServiceLoader.load(Service::class.java)
    val serviceImpl = loadService<Service>()
}