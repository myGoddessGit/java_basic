package com.kotlins

object KotlinGP {
    @JvmStatic
    fun main(args : Array<String>){
        val age = 23
        val name = "pipixia"
        val bool = true
        doPrintln(age)
        doPrintln(name)
        doPrintln(bool)
    }

    private fun <T> doPrintln(content : T){
        when (content){
            is Int -> println("整形数字为 $content")
            is String -> println("字符串转化成大写: ${content.toUpperCase()}")
            else -> println("T 不是整型, 也不是字符串")
        }
    }
}