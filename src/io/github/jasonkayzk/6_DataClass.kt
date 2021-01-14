package io.github.jasonkayzk

/**
 * 在Java中声明的POJO，通常需要重写equals、hashCode、toString等方法；
 *
 * 在Kotlin中，只需声明这个类是一个data(数据)类即可；
 *
 * Kotlin会自动根据"主构造方法中"的参数，将equals、hashCode、toString等方法自动生成！
 */
data class Cellphone(val brand: String, val price: Double)

fun main() {
    val cellphone1 = Cellphone("Samsung", 1299.99)
    val cellphone2 = Cellphone("Samsung", 1299.99)
    println(cellphone1)
    println("cellphone1 equals cellphone2 " + (cellphone1 == cellphone2))
}
