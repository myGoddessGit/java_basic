package com.kotlins

/**
 * @Author by chenYl on 2021/5/25 16:50
 * @Description :
 * @VERSION :
 * @TITLE :
 */
fun foo() : Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(100) // pretend we are computing it
        yield(i) // yield next value
    }
}

//fun main() {
//    foo().forEach { value -> println(value) }
//}

