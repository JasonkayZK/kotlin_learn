package io.github.jasonkayzk

/**
 * Kotlin中实现了类似于模板的内嵌变量字符串
 *
 * 语法规则：
 *
 *  "xxx ${obj} xxx"
 *
 * Kotlin中允许在字符串中嵌入`${}`表达式，在运行时，会先计算表达式，再创建字符串
 *
 * 注：当表达式仅有一个变量时，可以将大括号省略，如：
 *
 *   "xxx $obj xxx"
 */

fun main() {
    val brand = "Apple"
    val price = 1288
    println("Cellphone(brand=\${${brand}}, price=\${${price}})")
}
