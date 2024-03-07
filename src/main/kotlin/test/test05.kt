package org.example.test

import kotlinx.coroutines.*

private fun main() = runBlocking{
  startMain(this)
}
fun startMain(scope : CoroutineScope){
    scope.launch {
        test1()
        test2()
        test3()
    }
}

suspend fun test1(){
    println("1")
    delay(100)
}

suspend fun test2(){
    println("2")
    delay(300)
}
suspend fun test3(){
    println("3")
    delay(100)
}