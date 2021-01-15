package io.github.jasonkayzk

/**
 * Java在JDK 8中加入了@FunctionalInterface的注解，专门用来声明一个函数式接口(只能存在一个方法的接口)；
 *
 * 在Kotlin中调用Java的单抽象方法时，也可以直接传入Lambda（仅限于单抽象方法）
 *
 * 在Kotlin调用注册事件等方法时，会大量使用lambda；
 */
fun threadDemo() {
    Thread {
        println("Thread is running")
    }.start()
    /*
        变化过程：
            1.原始：由于Kotlin舍弃了new关键字，所以在创建匿名类实例时不能再使用new而是使用了object关键字：
                Thread(object : Runnable {
                    override fun run() {
                        println("Thread is running")
                    }
                }).start()
            2.Runnable仅有一个待实现方法，所以可以省略重写关键字：
                Thread(Runnable {
                    println("Thread is running")
                }).start()
            3.如果Java方法的参数列表不存在一个以上的Java单抽象方法接口参数，可以将接口名省略：
                Thread({
                    println("Thread is running")
                }).start()
            4.Lambda表达式是最后一个参数，可以移至外部，同时如果是唯一参数，可以省略括号：
                Thread {
                    println("Thread is running")
                }.start()
     */
}

fun main() {
    threadDemo()
}
