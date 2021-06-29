package com.kotlins

import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

object KotlinGP {
    @JvmStatic
    fun main(args : Array<String>){
//        val age = 23
//        val name = "pipixia"
//        val bool = true
//        doPrintln(age)
//        doPrintln(name)
//        doPrintln(bool)
        val testMap = HashMap<String, String>()
        val hashMap = hashMapOf<String, String>();
        testMap["a"] = "A"
        testMap["b"] = "B"
        testMap["c"] = "C"
        for ((key, value) in testMap){
            println("$key  $value")
        }
        val testMap2 = LinkedHashMap(testMap)
        testMap2.forEach{
            println("${it.key}  ${it.value}")
        }
        val testList = arrayListOf<String>()
        testList.add("a")
        testList.add("b")
        testList.parallelStream().map {

        }
        System.getProperties()
        val anyMatch = testList.contains("c")
        val anyMatch2 = testList.any{
            "c" == it
        }
        println(anyMatch)
        val testList2 = testList.filter {
           "a" == it
        }

        println(testList2)
    }

    private fun <T> doPrintln(content : T){
        when (content){
            is Int -> println("整形数字为 $content")
            is String -> println("字符串转化成大写: ${content.toUpperCase()}")
            else -> println("T 不是整型, 也不是字符串")
        }
    }
}