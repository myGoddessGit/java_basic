package com.designing.singleton.kotlin

// 懒汉 (线程安全)
class SingletonSafe_LH private constructor(){
    companion object {
        private var instance : SingletonSafe_LH? = null
        get() {
            if (field == null){
                field = SingletonSafe_LH()
            }
            return field
        }
        @Synchronized
        fun get() : SingletonSafe_LH{
            return instance!!
        }
    }
}