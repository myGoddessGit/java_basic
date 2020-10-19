package com.designing.singleton.kotlin

// 双重校验锁
class Singleton_DC private constructor(){
    companion object {
        val instance : Singleton_DC by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Singleton_DC()
        }
    }
}
// 双重校验锁
class Singleton_DC2 private constructor(private val property : Int){
    companion object {
        @Volatile private var instance : Singleton_DC2? = null
        fun getInstance(property: Int) =
                instance ?: synchronized(this){
                    instance ?: Singleton_DC2(property).also { instance = it }
                }
    }
}