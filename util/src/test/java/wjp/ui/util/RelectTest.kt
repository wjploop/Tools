package wjp.ui.util

import org.junit.Test

class RelectTest {

    open class A {
        constructor(p0: String)
        constructor(p0: Int)
        private constructor(p0: Int, p1: String)

        protected constructor(p0: Int, p1: String, f: Float)

        constructor()

    }

    class B : A()

    @Test
    fun testReflect() {
        val clzz = A::class.java
        val c = clzz.constructors
        println("woo")

        //getConstructors()返回的只有public的构造方法

        val cd = clzz.getDeclaredConstructor()

        val cB = B::class.java
        val ccb = cB.constructors
        println("test b")
    }
}