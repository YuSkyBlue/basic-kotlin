package org.example.test

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect

fun main() {
    runBlocking {
        val sharedStateFlow = MutableStateFlow(0) // Non-blocking shared variable

        val scope = CoroutineScope(Dispatchers.Default)

        // Non-blocking coroutine to update sharedStateFlow
        scope.launch {
            for (i in 1..5) {
                delay(100) // Simulate some computation
                sharedStateFlow.value = i // Update shared state non-blockingly
                println("1.Non-blocking: Updated sharedStateFlow to $i in ${Thread.currentThread().name}")
            }
        }

        // Non-blocking coroutine to collect updates from sharedStateFlow
        scope.launch {
            sharedStateFlow.collect { state ->
                if(state !=0){
                    println("2.Non-blocking: Collected updated state: $state in ${Thread.currentThread().name}")
                }

            }
        }

        // Example of blocking shared variable
        val completableDeferred = CompletableDeferred<Int>() // Blocking shared variable

        // Blocking coroutine to set value
        scope.launch {
            delay(500) // Simulate some computation
            completableDeferred.complete(99) // Complete with a value blockingly
            println("3.Blocking: Completed completableDeferred with 99 in ${Thread.currentThread().name}")
        }

        // Blocking coroutine to await and get value
        scope.launch {
            val value = completableDeferred.await() // Await blocks until the value is available
            println("4.Blocking: Received value $value from completableDeferred in ${Thread.currentThread().name}")
        }

        delay(1000) // Wait for a bit to let everything run
        scope.cancel() // Cancel the scope to stop all coroutines
    }
}