package io.github.jasonkayzk

/**
 * 对于OOP来说，崩溃率最高的异常就是NPE；
 */

// 来看下面的代码，为了防止study为null导致NPE，我们判断了study非空
fun doStudyNullCheck(study: Study) {
    if (study != null) {
        study.readBooks()
        study.doHomework()
    }
}
// 但是在上面的代码中对于study的判断是多余的：
// 因为在Kotlin中，默认所有的参数和变量都是非null的(并且Kotlin中去除了所有Java中的基本类型，所有的基本类型都变为了类！)
// 如果使用null调用了，Kotlin将无法通过编译：doStudyNullCheck(null)
// 即：Kotlin将null的判断提前到了编译期！

/**
 * 在"类型名后"添加`?`即声明为一个可空类型；
 *
 * 此时就需要判断study非空了!
 */
fun doStudyNullable(study: Study?) {
    // 将Study声明为可空下面的代码会报错；
    // 因为此时Kotlin编译器检测到可能会出现NPE
//    study.readBooks()
//    study.doHomework()

    // 需要手动判空:
    if (study != null) {
        study.readBooks()
        study.doHomework()
    }
}

fun main() {
    // 不可为空
//    doStudyNullCheck(null)

    // 可为空
    doStudyNullable(null)
}
