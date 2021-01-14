package io.github.jasonkayzk

/**
 * Kotlin将类的构造方法分为了两类：主构造方法和次构造方法；
 */

/**
 * 主构造方法：
 *
 *  每个类默认都存在一个不带参数的主构造函数，你也可以显式指明参数；
 *
 *  主构造方法的特点是：没有函数体，直接在类名后定义即可；
 */
open class Father {
    var name = ""
    var age = 0

    fun eat() {
        println("Person(name=$name), age=$age")
    }
}

/**
 * 这里我们将sno和grade放在了主构造方法，表面了在实例化时，必须传入构造方法要求的全部参数；
 * 例如：
 *  val child = Child("001", 12)
 *
 * 在继承时Kotlin规定：子类必须调用父类的构造方法，但是我们可以在init中调用；
 *
 * 但是绝大多数时候，可以在继承时声明调用父类的哪个构造方法，即通过Father()的方法；
 *
 */
class Child(val sno: String, val grade: Int) : Father() {}

/**
 * init结构体：
 *
 *  由于主构造方法中无函数体，所以如果想要在主构造方法中编写逻辑，需要使用init结构体
 */
class ChildWithInit(private val sno: String, private val grade: Int) {
    init {
        println("sno is $sno")
        println("grade is $grade")
    }
}

/**
 * 子类在继承时可以指定父类的其他构造方法
 */
open class FatherParam(private val name: String, private val age: Int) {
    fun eat() {
        println("Person(name=$name), age=$age")
    }
}

/**
 * 由于父类仅仅定义了一个有参的主构造方法，所以在继承时必须使用这个构造方法继承
 * 下面的方法会将传入给ChildParam的name和age传给FatherParam的构造函数
 * 同时由于：
 *  在主构造方法中声明为val或者var的参数将自动成为该类的字段
 * 所以这里的name和age前不必添加任何关键字，否则会和父类的字段冲突！
 */
class ChildParam(val sno: String, val grade: Int, name: String, age: Int) : FatherParam(name, age) {}

/**
 * 次构造方法：
 *
 *  任何类都仅能有一个主构造方法，但是可以有多个次构造方法；
 *
 *  次构造方法也可以用于实例化一个类，只是和主构造方法相比，次构造方法含有函数体；
 */

/**
 * 次构造方法通过constructor关键字定义；
 *
 * 同时，Kotlin规定，当一个类既有主构造方法又有次构造方法时：
 *
 *  所有的次构造方法都必须调用主构造方法（包括间接调用）
 */
/**
 * 下面的ChildMinorConstructor类共有三个构造方法：
 * 一个主构造方法和两个次构造方法；
 * 第一个次构造方法通过this直接调用了主构造方法；
 * 第二个次构造方法则调用了第一个次构造方法，从而间接调用了主构造方法；
 */
class ChildMinorConstructor(val sno: String, val grade: Int, name: String, age: Int) : FatherParam(name, age) {
    constructor(name: String, age: Int) : this("", 0, name, age) {}
    constructor() : this("", 0) {}
}

/**
 * 仅有次构造方法的类：Kotlin也是允许类中仅存在次构造方法没有主构造方法的；
 *
 * 当一个类未显式定义主构造方法且定义了次构造方法时，他就是没有主构造方法的；
 *
 * 注：
 *  此时父类FatherParam后无括号，这是因为：
 *      这时，子类无主构造方法，所以不需要在继承时指定父类的构造方法；
 *  而在次构造方法中，使用了super调用了父类的构造方法！
 */
class ChildNoMainConstructor : FatherParam {
    constructor(name: String, age: Int) : super(name, age) {}
}


fun main() {
    // 使用主构造方法构造实例
    val childParam = ChildParam("123", 5, "Tim", 19)
    childParam.eat()

    // 分别调用不同构造方法创建实例
    val stu1 = ChildMinorConstructor()
    val stu2 = ChildMinorConstructor("Jack", 19)
    val stu3 = ChildMinorConstructor("123", 5, "Tom", 19)

    // 初始化仅有次构造方法的类
    val childNoMainConstructor = ChildNoMainConstructor("Tom", 19)
}
