package ch06

import junit.framework.Assert.assertEquals
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MyService {
    fun performAction(): String = "foo"
}

class MyTest {
    private var myService: MyService? = null
    private lateinit var myService2: MyService // 나중에 초기화. 항상 var
    //특별한 메소드에서 초기화할 수 없다. (생성자에서 초기화 하거나, 널이 될 수 있는 타입 쓰거나)
    //private var myService: MyService

    @Before
    fun setUp() {
        myService2 = MyService()
    }

    @Test
    fun testAction() {
        Assert.assertEquals("foo",
            myService2.performAction())
    }
}