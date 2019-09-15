package wjp.ui.util.reflect

/**
 * 获取Class对象
 *
 * 1. 类名字符串
 *      Class.for("java.lang.Object")
 *
 * 2. 类名.class
 *      Object.class
 *
 * 3. 实例对象.getClass
 *
 *
 *
 * 获取构造函数
 *
 *
 * 获取参数列表为parameterType, 且是public的
 * public Constructor getConstructor( Class[] parameterTypes )
 *
 *
 * 获取所有是public
 * public Constructor getConstructor()
 *


 */

private class A

fun main() {

    val clzz = A::class.java
    val c = clzz.constructors
}

