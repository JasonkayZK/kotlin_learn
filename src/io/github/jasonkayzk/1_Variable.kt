package io.github.jasonkayzk

fun main() {
    // val表示不可变变量
    val a = 10
    // a = 20
    println("a = $a")

    // 声明变量时指定类型，取消类型推断
    val b: Long = 20
    // b = 30
    println(b)

    // var声明一个可变变量
    var c = 30
    c = 25
    println(c)
}
