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

fun main() {
    val a = 37
    val b = 40
    val value = largerNumber(a, b)
    println(value)

    val value2 = largerNumber2(a, b)
    println(value2)

    val value3 = largerNumber3(a, b)
    println(value3)
}
