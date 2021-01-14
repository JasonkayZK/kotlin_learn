package io.github.jasonkayzk

/**
 * Person指定了name和age两个字段，以及一个eat方法；
 *
 * Kotlin默认为public修饰；
 *
 * 默认情况下Kotlin的类都是不可继承的(final)，使用open修饰则变为可继承；
 */
open class Person {
    var name = ""
    var age = 0

    fun eat() {
        println("Person(name=$name), age=$age")
    }
}

fun main() {
    // Kotlin中去掉了new关键字
    val p = Person()
    p.name = "Tom"
    p.age = 18
    p.eat()
}
