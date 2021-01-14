## **Kotlin面向对象**

### **类与对象**

-   类的声明：class关键字；
-   创建对象实例：无new关键字；



### **继承**

-   默认类无法继承，父类需要声明为open；
-   Kotlin使用冒号`:`实现类继承和接口实现；
-   **在继承时Kotlin规定：子类必须调用父类的构造方法，但是我们可以在init中调用；**
-   绝大多数时候，在继承时声明调用父类的哪个构造方法，即通过super()的方式；



### **构造方法**

-   构造方法分为：主构造方法和次构造方法；
-   主构造方法：
    -   每个类默认都存在一个不带参数的主构造函数，也可以显式指明参数；
    -   主构造方法的特点是：没有函数体，直接在类名后定义即可；
    -   由于主构造方法中无函数体，所以如果想要在主构造方法中编写逻辑，需要使用init结构体；
    -   子类在继承时需要指定使用父类的哪个构造方法；
-   次构造方法：
    -   任何类都仅能有一个主构造方法，但是可以有多个次构造方法；
    -   次构造方法也可以用于实例化一个类，只是和主构造方法相比，次构造方法含有函数体；
    -   次构造方法通过constructor关键字定义；
    -   同时，Kotlin规定：**当一个类既有主构造方法又有次构造方法时：所有的次构造方法都必须调用主构造方法（包括间接调用）；**
-   仅有次构造方法的类：
    -   Kotlin允许类中仅存在次构造方法没有主构造方法，当一个类未显式定义主构造方法且定义了次构造方法时，他就是没有主构造方法的；
    -   **此时父类Father后不需要括号，这是因为：这时，子类无主构造方法，所以不需要在继承时指定父类的构造方法；而在次构造方法中，需要使用super调用父类的构造方法！**



### **接口**

-   Kotlin中的接口和Java几乎完全相同；
-   Kotlin中继承和实现接口统一使用冒号：`:`；
-   可以在接口中直接定义函数体，作为接口的默认方法；



### **可见性修饰符**

-   **在Java中不写修饰符默认为default，即包可见；而在Kotlin中默认为public！**
-   在Kotlin中分为public、private、protected和internal：
    -   public：所有类可见(默认)；
    -   private：当前类可见；
    -  protected：当前类和子类可见；
    -  internal：同一个模块中的类可见；



### **数据类**

-   在Java中声明的POJO，通常需要重写equals、hashCode、toString等方法；
-   在Kotlin中，只需声明这个类是一个data(数据)类即可；
-   Kotlin会自动根据"主构造方法中"的参数，将equals、hashCode、toString等方法自动生成！



### **单例类**

-   为了避免创建重复的对象，设计模式中经常使用单例类；单例类可以使用懒汉式、饿汉式，以双检查锁的形式实现；
-   而Kotlin提供了创建单例类的简便方法：将class关键字改为object即可；

例如：

7_Singleton.kt

```kotlin
object Singleton {
    // 下面的方法仅会调用一次，由Kotlin保证全局仅会存在一个实例！
    init {
        println("singleton created!")
    }
    fun singletonTest() {
        println("singletonTest is called.")
    }
}

fun main() {
    val singleton1 = Singleton
    val singleton2 = Singleton

    // 可以使用类似于Java中静态方法的方式调用
    Singleton.singletonTest()
    singleton1.singletonTest()
    singleton2.singletonTest()
}
```

