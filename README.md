## **Lambda编程**

### **初始化和遍历集合**

-   除了传统的Java初始化方式，可以使用XxxOf和MutableXxxOf初始化并创建不可变/可变集合；

-   Kotlin中建议使用类似于数组的方式访问Map，如：`map["apple"] = 1`；

-   在初始化Map时，可以使用mapOf、mutableMapOf配合infix函数`to`完成初始化，如：`val map = mapOf("apple" to 1, "banana" to 2, "orange" to 3)`；

    **注：to并不是关键字，而是一个infix函数，对于 a to b实际上是调用了a.to(b)；**

-   在变量map时可以在for-in中使用类似于tuple对的方式变量key和value，如：`for ((key, value) in map)`；



### **集合函数式API**

Kotlin中集合的函数式编程和 JDK 8中引入的函数式编程类似；

* Lambda本质上就是一个函数，所以可以创建一个lambda表达式，并且以类似于函数调用的方式调用；
* Lambda表达式完整语法：**{参数名1：参数类型，参数名2：参数类型 -> 函数体 }**
* **注：**
  -   1.函数体的最后一行代码会被自动作为lambda表达式的返回值；
  -   2.通常情况下会使用Lambda的简写形式；
* 一些常用的集合API：
    -   maxBy；
    -   map & filter；
    -   any & all；
    -   ……



### **Java函数式API**

Java在JDK 8中加入了`@FunctionalInterface`的注解，专门用来声明一个函数式接口(只能存在一个方法的接口)；

在Kotlin中调用Java的单抽象方法时，也可以直接传入Lambda（仅限于单抽象方法）;

在Kotlin调用注册事件等方法时，会大量使用lambda；

例如：

3_FunctionalInterface.kt

```kotlin
fun threadDemo() {
    Thread {
        println("Thread is running")
    }.start()
    /*
        变化过程：
            1.原始：由于Kotlin舍弃了new关键字，所以在创建匿名类实例时不能再使用new而是使用了object关键字：
                Thread(object : Runnable {
                    override fun run() {
                        println("Thread is running")
                    }
                }).start()
            2.Runnable仅有一个待实现方法，所以可以省略重写关键字：
                Thread(Runnable {
                    println("Thread is running")
                }).start()
            3.如果Java方法的参数列表不存在一个以上的Java单抽象方法接口参数，可以将接口名省略：
                Thread({
                    println("Thread is running")
                }).start()
            4.Lambda表达式是最后一个参数，可以移至外部，同时如果是唯一参数，可以省略括号：
                Thread {
                    println("Thread is running")
                }.start()
     */
}

fun main() {
    threadDemo()
}
```

