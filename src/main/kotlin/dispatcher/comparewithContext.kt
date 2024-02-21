package org.example.dispatcher
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

private fun main() = runBlocking {
    val timeIO = measureTimeMillis {
        repeat(1000) {
         performIOOperation()
        }

    }
    println("Time taken for IO operation: $timeIO ms")

    val timeDefault = measureTimeMillis {
        repeat(1000) {
            performDefaultOperation()
        }
    }
    println("Time taken for Default operation: $timeDefault ms")
}

// Simulate an IO operation more realistically
private suspend fun performIOOperation() = withContext(Dispatchers.IO) {
    // Simulating IO work by a non-blocking delay which represents asynchronous IO tasks
    // In real-world scenarios, replace this with actual IO work like file or network operations
    delay(1) // Simulating non-blocking IO delay
}

// Simulate a CPU-intensive operation more accurately
private suspend fun performDefaultOperation() = withContext(Dispatchers.Default) {
    // Simulating CPU work by doing a computation instead of delay
    // In real-world scenarios, replace this with actual computation like sorting or parsing
    val list = (1..1000).toList()
    list.sortedBy { it % 3 }
}