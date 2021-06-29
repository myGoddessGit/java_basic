package com.kotlins

/**
 * @Author by chenYl on 2021/6/21 18:16
 * @Description :  高阶函数
 * @VERSION :
 * @TITLE :
 */

object HighFunction {

    @JvmStatic
    fun main(args : Array<String>){
//        val letters = listOf("Uzi", "Faker")
//        println(letters.joinToString())
//        println(letters.joinToString { it.toLowerCase() })
//        println(letters.joinToString(separator= "!", postfix= "!", transform={it.toUpperCase()}))
//        val cal = getShippingCost(Delivery.EXPEDITED)
//        println("Shipping costs ${cal(Order(3))}")
        val user = listOf(User("Alice", 29), User("Bob", 31))
        fun search(user: List<User>) {
            for (person in user){
                if (person.name == "Alice"){
                    println("Found!")
                    return
                }
            }
            println("Alice is not found")
        }
        search(user)

        fun search1(people: List<User>) {
            people.forEach {
                if(it.name == "Alice") {
                    println("Found!")
                    return
                }
            }
            println("Alice is not found")
        }
        search1(user)
    }

    private fun <T> Collection<T>.joinToString(
            separator : String = ", ",
            prefix: String = "",
            postfix: String = "",
            transform : (T) -> String = {it.toString()}
    ) : String{
        val result = StringBuilder(prefix)
        for ((index, element) in this.withIndex()){
            if (index > 0){
                result.append(separator)
            }
            result.append(transform(element))
        }
        result.append(postfix)
        return result.toString()
    }

    private fun getShippingCost(delivery: Delivery) : (Order) -> Double {
        if (delivery == Delivery.EXPEDITED){
            return {order ->  6 + 2.1 * order.itemCount}
        }
        return {order -> 1.2 * order.itemCount}
    }


}

enum class Delivery {STANDARD, EXPEDITED}
class Order(val itemCount: Int)
data class User(val name : String, val age : Int)



