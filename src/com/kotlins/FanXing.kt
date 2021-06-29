package com.kotlins

import javax.xml.bind.JAXBElement

class A<T> (val t : T, val t2 : T, val t3 : T)
class Apple(var name : String)
object FanXing{
    @JvmStatic
    fun main(args : Array<String>){
        /**
         * 星型投射
         */
        val a1 :A<*> = A(12, "String", Apple("苹果"))
        val a2 :A<Any?> = A(12, "String", Apple("苹果"))
        val apple = a1.t3  // 参数类型为Any
        println(apple)
        val apple2 = apple as Apple // 强转成Apple类
        println(apple2.name)
        // 使用数组
        val l : ArrayList<*> = arrayListOf("String", 1, 1.2f, Apple("苹果"))
        for (item in l){
            println(item)
        }
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
    }
}

class C {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    fun test(){

    }
}
