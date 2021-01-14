package io.github.jasonkayzk

/**
 * Kotlin中的接口和Java几乎完全相同
 */
interface Study {
    fun readBooks()
    fun doHomework()
    // 提供默认方法
    fun study() {
        println("i'm studying")
    }
}

open class StudyFather(val name: String, val age: Int) {}

/**
 * Kotlin中继承和实现接口统一使用冒号：":"
 */
class StudyImpl(name: String, age: Int) : StudyFather(name, age), Study {
    override fun readBooks() {
        println("$name is reading")
    }

    override fun doHomework() {
        println("$name is doing homework")
    }
}

fun doStudy(study: Study) {
    study.readBooks()
    study.doHomework()
    study.study()
}

fun main() {
    val stu = StudyImpl("Tom", 18)
    doStudy(stu)
}
