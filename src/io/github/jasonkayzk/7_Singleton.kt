package io.github.jasonkayzk

/**
 * 为了避免创建重复的对象，设计模式中经常使用单例类；
 *
 * 单例类可以使用懒汉式、饿汉式，以双检查锁的形式实现；
 *
 * 而Kotlin提供了创建单例类的简便方法：将class关键字改为object即可；
 */
object Singleton {
    // 下面的方法仅会调用一次，由Kotlin保证全局仅会存在一个实例！
    init {
        println("singleton created!")
    }

    fun singletonTest() {
        println("singletonTest is called.")
    }
}

fun main() {
    val singleton1 = Singleton
    val singleton2 = Singleton

    // 可以使用类似于Java中静态方法的方式调用
    Singleton.singletonTest()
    singleton1.singletonTest()
    singleton2.singletonTest()
}
