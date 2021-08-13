package ch07

import java.beans.PropertyChangeListener
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Person6 (
    val name: String, age: Int, salary: Int
        ) : PropertyChangeAware() {
            private val observer = {
                prop: KProperty<*>, oldValue: Int, newValue: Int -> changeSupport.firePropertyChange(prop.name, oldValue, newValue)
            }

            var age: Int by Delegates.observable(age, observer)
            var salary: Int by Delegates.observable(salary, observer)
        }

fun main(args: Array<String>) {
    val p = Person6("Dmitry", 34, 2000)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed "
                    + "from ${event.oldValue} to ${event.newValue}")
        }
    )
    p.age = 35 // Property age changed from 34 to 35
    p.salary = 2100 // Property salary changed from 2000 to 2100
}