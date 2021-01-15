package io.github.jasonkayzk

// 传统Java初始化集合方式
fun initListInJava() {
    val list = ArrayList<String>()
    list.add("apple")
    list.add("banana")
    list.add("pear")
    println(list)
}

/**
 * Kotlin中加入了listOf简化初始化集合:
 *
 *  listOf创建的集合是不可变的：只能读取，不可添加、修改、删除！
 */
fun initList() {
    val list = listOf("Apple", "banana", "pear")
    println(list)
}

/**
 * 使用mutableListOf即可创建可变集合
 */
fun initMutableList() {
    val list = mutableListOf("Apple", "banana", "pear")
    list.add("grape")
    println(list)
}

/**
 * 初始化集合与List类似，存在：setOf、mutableSetOf两个方法
 *
 * 注：Set底层使用的是hash映射，所以和Java一样，不保证遍历顺序
 */
fun initSet() {
    val set1 = setOf("a", "b", "c", "d", "a")
    println(set1)
    val set2 = mutableSetOf("a", "b", "c", "d", "a")
    println(set2)
}

// Java中初始化一个Map
fun initMapInJava() {
    val map = HashMap<String, Int>()
    map.put("apple", 1)
    map.put("banana", 2)
    map.put("orange", 3)
    println(map)
}

/**
 * Kotlin中建议使用类似于数组的方式访问Map
 */
fun traverseMap() {
    val map = HashMap<String, Int>()
    map["apple"] = 1
    map["banana"] = 2
    map["orange"] = 3
    println(map)
}

/**
 * 同时，在初始化Map时，可以使用mapOf、mutableMapOf配合infix函数`to`完成初始化
 *
 * 注：to并不是关键字，而是一个infix函数，对于 a to b实际上是调用了a.to(b)
 */
fun initMap() {
    val map = mapOf("apple" to 1, "banana" to 2, "orange" to 3)
    println(map)
}

/**
 * 在变量map时可以在for-in中使用类似于tuple对的方式变量key和value
 */
fun traverseMapWithForIn() {
    val map = mapOf("apple" to 1, "banana" to 2, "orange" to 3)
    for ((key, value) in map) {
        print("(key: $key, value: $value) ")
    }
    println()
}

fun main() {
    // List
    initListInJava()
    initList()
    initMutableList()

    // Set
    initSet()

    // Map
    initMapInJava()
    traverseMap()
    initMap()
    traverseMapWithForIn()
}
