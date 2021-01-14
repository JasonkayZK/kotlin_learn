package io.github.jasonkayzk

// 基本If语句
fun largerNumberWithIf(num1: Int, num2: Int): Int {
    var value = 0
    if (num1 > num2) {
        value = num1
    } else {
        value = num2
    }
    return value
}

// Kotlin中的If存在返回值，返回值就是每个条件中的最后一行
fun largerNumberWithIf2(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}

// 代码只有一行时的精简
fun largerNumberWithIf3(num1: Int, num2: Int): Int = if (num1 > num2) {
    num1
} else {
    num2
}

// if中单行语句去掉大括号
fun largerNumberWithIf4(num1: Int, num2: Int): Int = if (num1 > num2) num1 else num2

fun getScore(name: String) = if (name == "Tom") {
    86
} else if (name == "Jim") {
    77
} else {
    0
}

// 将getScore用When替换
// when允许传入一个任意类型的参数，然后再when的结构体中定义一系列的条件：匹配值 -> { 执行逻辑 }
// 当执行逻辑仅有一行时，可以将大括号省略
fun getScoreWithWhen(name: String) = when (name) {
    "Tom" -> 86
    "Jim" -> 77
    else -> 0
}

// 使用when进行类型匹配
// is相当于java中的instanceof，Number是Int、Double等类型的子类
fun checkNumber(num: Number) {
    when (num) {
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not support")
    }
}

// 无参数when
fun getScoreWithWhen2(name: String) = when {
    name.startsWith("Tom") -> 86
    name == "Jim" -> 77
    else -> 0
}

fun main() {
    val num = 10
    checkNumber(num)
    val num2 = 10L
    checkNumber(num2)
}
