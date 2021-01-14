package io.github.jasonkayzk

// While语句和Java一模一样
fun whileDemo() {
    var i = 0
    while (i < 10) {
        print("${i++} ")
    }
    println()
}

// Kotlin中的区间
fun rangeDemo() {
    // [0,10]
    printRange(0..10)
    // [0,10)
    printRange(0 until 10)
    // [0,2,4,6,8)
    printRange(0 until 10 step 2)
    // [10,1]
    printRange(10 downTo 1)
}

// Kotlin舍弃了Java中的for-i形式，而是加强了for-in和for-each
fun printRange(arr : IntProgression) {
    for (i in arr) {
        print("$i ")
    }
    println()
}

// For遍历集合
fun forCollection() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    for (fruit in list) {
        print("$fruit ")
    }
    println()
}

fun main() {
    whileDemo()
    rangeDemo()
    forCollection()
}
