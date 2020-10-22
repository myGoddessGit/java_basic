package com.collection


import java.util.Collections
import kotlin.collections.ArrayList

object SortTest {
    @JvmStatic
    fun main(args : Array<String>){
        val lists = ArrayList<String>();
        lists.add("5")
        lists.add("4")
        lists.add("6")
        lists.add("9");
        lists.sort()

        val listA = ArrayList<SortA>();
        val al = SortA()
        al.name = "a"
        al.order = 2
        val a2 = SortA()
        a2.name = "b"
        a2.order = 1
        val a3 = SortA()
        a3.name = "c"
        a3.order = 5
        listA.add(al)
        listA.add(a2)
        listA.add(a3)

        listA.sort()

//        println(lists);
//        println(listA);
        val listB = ArrayList<SortB>()
        val b1 = SortB()
        b1.name = "a"
        b1.order = 2
        val b2 = SortB()
        b2.name = "b"
        b2.order = 3
        val b3 = SortB()
        b3.name = "c"
        b3.order = 5
        val b4 = SortB()
        b4.name = "d"
        b4.order = 1

        listB.add(b1)
        listB.add(b2)
        listB.add(b3)
        listB.add(b4)

        listB.sortWith(Comparator { s1, s2 ->
            s2.name.compareTo(s1.name) // 倒序
        })

        println(listB)
    }
}