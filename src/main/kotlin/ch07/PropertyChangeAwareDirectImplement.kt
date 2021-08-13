package ch07

import java.beans.PropertyChangeListener

class Person4 (
    val name: String, age: Int, salary: Int
        ) : PropertyChangeAware() {
            var age: Int = age
                set(newValue) {
                    val oldValue = field // 뒷받침하는 필드에 접근할 때 "field"식별자를 사용
                    field = newValue
                    changeSupport.firePropertyChange( // 프로퍼티 변경을 리스너에게 통지
                        "age", oldValue, newValue
                    )
                }
            var salary: Int = salary
                set(newValue) {
                    val oldValue = field
                    field = newValue
                    changeSupport.firePropertyChange(
                        "salary", oldValue, newValue
                    )
                }
        }

fun main(args: Array<String>) {
    val p = Person4("Dmitry", 34, 2000)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed "
                    + "from ${event.oldValue} to ${event.newValue}")
        }
    )
    p.age = 35 // Property age changed from 34 to 35
    p.salary = 2100 // Property salary changed from 2000 to 2100
}