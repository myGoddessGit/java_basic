package com.kotlins

/**
 * @Author by chenYl on 2021/6/16 18:05
 * @Description :
 * @VERSION :
 * @TITLE :
 */
data class Point(val x : Int, val y : Int)
operator fun Point.inc() = Point(x, y)

object DataTest {
    @JvmStatic
    fun main(array: Array<String>){
        var p = Point(1,1);
        val np = ++p
        println(np)
    }
}

class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}