package io.github.jasonkayzk

/**
 * Kotlin中集合的函数式编程和 JDK 8中引入的函数式编程类似；
 *
 * Lambda表达式完整语法：
 *
 *  {参数名1：参数类型，参数名2：参数类型 -> 函数体 }
 *
 * 注：
 *
 *  1.函数体的最后一行代码会被自动作为lambda表达式的返回值
 *
 *  2.通常情况下会使用Lambda的简写形式
 *
 * 下面给出几个例子；
 */

/**
 * lambda本质上是一个函数
 *
 * 所以可以创建一个lambda表达式，并且以类似于函数调用的方式调用
 */
fun lambdaDemo() {
    val lamb = { a: Int, b: Int ->
        {
            a + b
        }
    }
    println(lamb)
    // 注：最后的调用括号不可少！
    println(lamb(1, 2)())
}

// 寻找集合中最长的字符串
fun findMaxLength() {
    val list = listOf("apple", "banana", "pear", "orange", "grape", "watermelon")

    // 下面的代码实际上是简写：maxBy接收一个Lambda表达式
    val maxLengthItem = list.maxBy { it.length }
    /*
        变化步骤：
            1.完整：
                list.maxBy({ fruit: String -> fruit.length })
            2.当Lambda是函数最后一个参数，可将Lambda移到括号外面：
                list.maxBy() { fruit: String -> fruit.length }
            3.当Lambda是唯一参数，可以将括号省略:
                list.maxBy { fruit: String -> fruit.length }
            4.通过类型推导判断类型：
                list.maxBy { fruit -> fruit.length }
            5.当Lambda仅有一个参数时，可以不必声明参数名，而是使用`it`关键字代替：
                list.maxBy { it.length }
     */
    println("maxLengthItem is: $maxLengthItem")
}

// map和filter函数例子
fun toUpperCase() {
    val list = listOf("apple", "banana", "pear", "orange", "grape", "watermelon")
    val newList = list
        .filter { it.length <= 5 }
        .map { it.toUpperCase() }
    println(newList)
}

// all和any函数例子
fun anyAllDemo() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    // 存在一个元素满足
    val anyResult = list.any { it.length <= 5 }
    // 所有元素满足
    val allResult = list.all { it.length <= 5 }
    println("anyResult is: $anyResult, allResult is: $allResult")
}


fun main() {
    lambdaDemo()
    findMaxLength()
    toUpperCase()
    anyAllDemo()
}
