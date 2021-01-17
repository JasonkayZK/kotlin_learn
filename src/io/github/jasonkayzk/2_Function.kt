package io.github.jasonkayzk

import kotlin.math.max

// 标准函数定义
fun largerNumber(num1: Int, num2: Int): Int {
    return max(num1, num2)
}

// 单行代码可以省略函数体，用等号定义函数体
fun largerNumber2(num1: Int, num2: Int): Int = max(num1, num2)

// 能推断出返回值时，可省略返回值类型
fun largerNumber3(num1: Int, num2: Int) = max(num1, num2)

/**
 * 函数默认值：
 *
 *  函数可以设定默认参数(这也是Kotlin中次构造方法使用较少的原因)
 */
fun printParams(num: Int, str: String = "hello") = println("num is $num, str is $str")

/**
 * Kotlin中的默认参数不是必须是末尾参数，如下；
 *
 * 但是在调用时，不能仅传递一个字符串，下面的代码报错：
 *
 *  printParams2("hello")
 *
 * 因为此时Kotlin认为是在给第一个参数(Int)传值！
 *
 * 可以使用类似于Python中键值对的方式传值调用函数：
 *
 *  printParams2(str = "hello")
 *
 * 此时参数顺序就无关紧要了！
 */
fun printParams2(num: Int = 100, str: String) = println("num is $num, str is $str")

fun main() {
    val a = 37
    val b = 40
    val value = largerNumber(a, b)
    println(value)

    val value2 = largerNumber2(a, b)
    println(value2)

    val value3 = largerNumber3(a, b)
    println(value3)

    printParams(123)
    printParams(123, "goodbye")

    // 报错：Kotlin认为是在给第一个参数(Int)传值！
//    printParams2("hello")
    // 显式传参
    printParams2(str = "hello")
}
