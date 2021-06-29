package com.data_structures.hashmap

/**
 * @Author by chenYl on 2021/3/18 14:56
 * @Description :
 * @VERSION :
 * @TITLE :
 */

object HashMapTest {

    @JvmStatic
    fun main(args : Array<String>){
        test()
    }

    private fun test(){
        val a = HashMap<Int, String>();
        a['a'.toInt()] = "A"
        a['b'.toInt()] = "B"
        a['c'.toInt()] = "C"
        a.forEach {
            (key, value) ->
            run {
                println("$key  $value")
            }
        }
    }
}