package ch07

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

/* 두 메소드의 시그니처를 코틀린의 관례에 맞게 수정하기 전
class ObservableProperty (
    val propName: String, var propValue: Int,
    val changeSupport: PropertyChangeSupport
        ) {
    fun getValue() : Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}
 */

// 두 메소드의 시그니처를 코틀린의 관례에 맞게 수정
class ObservableProperty (
    var propValue: Int, val changeSupport: PropertyChangeSupport
        ) {
    operator fun getValue(p: Person5, prop: KProperty<*>) : Int = propValue
    operator fun setValue(p: Person5, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

/*
class Person5 (
    val name: String, age: Int, salary: Int
        ) : PropertyChangeAware() {
            val _age = ObservableProperty("age", age, changeSupport)
            var age: Int
                get() = _age.getValue()
                set(value) { _age.setValue(value) }
            val _salary = ObservableProperty("salary", salary, changeSupport)
            var salary: Int
                get() = _salary.getValue()
                set(value) { _salary.setValue(value) }
        }

 */

class Person5 (
    val name: String, age: Int, salary: Int
        ) : PropertyChangeAware() {
            var age: Int by ObservableProperty(age, changeSupport) // by 오른쪽에 오는 객체 - 위임 객체
            var salary: Int by ObservableProperty(salary, changeSupport)
        }

fun main(args: Array<String>) {
    val p = Person5("Dmitry", 34, 2000)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed "
                    + "from ${event.oldValue} to ${event.newValue}")
        }
    )
    p.age = 35 // Property age changed from 34 to 35
    p.salary = 2100 // Property salary changed from 2000 to 2100
}