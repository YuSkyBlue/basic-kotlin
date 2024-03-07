package org.example.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect

private suspend fun sendNumbers(sharedFlow: MutableSharedFlow<Int>) {
    for (x in 1..5) {
        sharedFlow.emit(x) // Send numbers 1 to 5 to the shared flow
        delay(100) // Simulate some work
    }
}

private fun main(): Unit = runBlocking {
    val sharedFlow = MutableSharedFlow<Int>() // Create a new shared flow

    // Launch the first receiver
    launch {
        sharedFlow.collect { value ->
            println("Receiver 1 received: $value")
        }
    }

    // Launch the second receiver
    launch {
        sharedFlow.collect { value ->
            println("Receiver 2 received: $value")
        }
    }

    // Launch a coroutine to send numbers
    launch { sendNumbers(sharedFlow) }
}