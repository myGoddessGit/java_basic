package com.designing.singleton.kotlin

// 懒汉
class Singleton_LH private constructor(){
    companion object {
        private var instance : Singleton_LH? = null
        get() {
            if (field == null){
                field = Singleton_LH()
            }
            return field
        }
        fun get() : Singleton_LH{
            return instance!!
        }
    }
}