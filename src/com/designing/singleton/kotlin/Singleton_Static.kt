package com.designing.singleton.kotlin

// 静态内部类
class Singleton_Static private constructor(){
    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = Singleton_Static()
    }
}