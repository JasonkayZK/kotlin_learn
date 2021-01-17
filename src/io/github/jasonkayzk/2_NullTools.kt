package io.github.jasonkayzk

/**
 * Kotlin提供了一系列判断null的工具
 */

/**
 * `?.`运算符：
 *
 *  当对象不为空时正常调用，当对象为空时什么都不做，相当于：if (x != null) a.xxx()
 */
fun doStudyWithCheck(study: Study?) {
    study?.readBooks()
    study?.doHomework()
}

/**
 * `?:`运算符：
 *
 *  操作符左右各接收一个表达式，如果左表达式不为空，则返回左表达式；否则返回右表达式；
 *
 *  如：val c = a ?: b
 */
// 获取文本长度
// 如果text为空，则text?.length为null，返回0，否则返回text.length
fun getTestLength(text: String?) = text?.length ?: 0

/**
 * `!!.`运算符：
 *
 *  有时Kotlin审查过于严格，如在其他函数已判断非空，但是本函数中未判空时仍然无法通过编译；
 *
 *  此时可以通过`!!.`运算符跳过编译器检查；(但是非常不推荐这样的做法，毕竟可以直接声明非空！)
 */
var content: String? = "hello"
fun printUpperCase() {
    // 在main中判断过null，在此仍旧报错！
//    val upper = content.toUpperCase()

    // 取消编译器null检查
    val upper = content!!.toUpperCase()
    println(upper)
}

/**
 * let函数：
 *
 *  let函数将原始调用对象作为参数传入Lambda中，例如：
 *
 *  obj.let { obj2 -> xxx }
 *
 *  其中obj2就是obj本身(为了防止变量重名，改为了obj2)；
 *
 * 我们可以借助let函数搭配.?运算符，实现简化null判断
 */
fun doStudyWithLet(study: Study?) {
    study?.let {
        it.readBooks()
        it.doHomework()
    }
}

/**
 * 相比于if，let可以处理全局变量判空问题；
 *
 * 例如下面的代码；
 */
// 使用var声明全局变量
var stu: Study? = null
fun doStudyGlobal() {
    // 下面的代码报错，因为全局变量的值随时可能被其他线程修改；
//    if (stu != null) {
//        stu.doHomework()
//        stu.readBooks()
//    }

    // 下面的代码可以正常执行！
    stu?.let {
        it.doHomework()
        it.readBooks()
    }
}


fun main() {
    doStudyWithCheck(null)

    println(getTestLength(null))
    println(getTestLength(""))
    println(getTestLength("abc"))

    if (content != null) {
        printUpperCase()
    }

    doStudyWithLet(null)
    doStudyGlobal()
}
