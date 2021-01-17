## **空指针检查**

对于OOP来说，崩溃率最高的异常就是NPE；

来看下面的代码，为了防止study为null导致NPE，我们判断了study非空

```kotlin
fun doStudyNullCheck(study: Study) {
    if (study != null) {
        study.readBooks()
        study.doHomework()
    }
}
```

但是在上面的代码中对于study的判断是多余的：

因为在Kotlin中，默认所有的参数和变量都是非null的(并且Kotlin中去除了所有Java中的基本类型，所有的基本类型都变为了类！)

如果使用null调用了，Kotlin将无法通过编译：doStudyNullCheck(null)

**即：Kotlin将null的判断提前到了编译期！**



### **可空类型**

在"类型名后"添加`?`即声明为一个可空类型；

此时就需要判断study非空了!

```kotlin
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
```



### **判空工具**

Kotlin提供了一系列判断null的工具：

-   `?.`运算符：

    -   当对象不为空时正常调用，当对象为空时什么都不做，相当于：`if (x != null) a.xxx()`；

-   `?:`运算符：

    -   操作符左右各接收一个表达式，如果左表达式不为空，则返回左表达式；否则返回右表达式；
    -   如：val c = a ?: b；

-   `!!.`运算符：

    -   有时Kotlin审查过于严格，如在其他函数已判断非空，但是本函数中未判空时仍然无法通过编译；
    -   此时可以通过`!!.`运算符跳过编译器检查；(但是非常不推荐这样的做法，毕竟可以直接声明非空！)；

-   `let`函数：

    -   let函数将原始调用对象作为参数传入Lambda中，例如：`obj.let { obj2 -> xxx }`；其中obj2就是obj本身(为了防止变量重名，改为了obj2)；

    -   我们可以借助let函数搭配.?运算符，实现简化null判断；

    -   相比于if，let可以处理全局变量判空问题，例如下面的代码：

        ```kotlin
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
        ```

