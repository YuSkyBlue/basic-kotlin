package org.example.test

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger

private fun main() = runBlocking {
    val sharedState = AtomicInteger(0)

    val updateJob = launch {
        sharedState.set(42) // Update shared state
    }
    println("Shared state is ${sharedState.get()}") // Read updated state

    updateJob.join() // Wait synchronously for the update to complete

    println("Shared state is ${sharedState.get()}") // Read updated state
}
