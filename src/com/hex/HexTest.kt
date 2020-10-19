package com.hex

import java.util.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

object HexTest {
    @JvmStatic
    fun main(args : Array<String>){
        print("请输入一个十进制数: ")
        val input = Scanner(System.`in`)
        val n = input.nextInt()
        print("转换的进制: ")
        val m = input.nextInt()
        print("转换的${m}进制数为: ${intToHex(n, m)}")
    }

    private fun intToHex(c : Int, d : Int) : String {
        var m = c
        var s = StringBuffer()
        var a = String()
        while (m != 0){
            s = s.append(chooseHex(d)!![m % d])
            m /= d
        }
        a = s.reverse().toString()
        return a
    }

    private fun chooseHex(n : Int) : CharArray? {
        val a = ReentrantLock()
        val hex2 : CharArray = charArrayOf('0', '1')
        val hex4 = charArrayOf('0', '1', '2', '3')
        val hex8 = charArrayOf('0','1','2','3','4','5','6','7')
        val hex16 = charArrayOf('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F')
        return when (n){
            2 -> hex2
            4 -> hex4
            8 -> hex8
            16 -> hex16
            else -> null
        }
    }
}