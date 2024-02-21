package org.example.callback

import kotlinx.coroutines.*

// This function now suspends, indicating it can make use of coroutine suspension points
private suspend fun performOperationWithCallback(input: String, callback: (result: String) -> Unit) {
    // Simulate some time-consuming operation
    delay(1000) // Delays for 1 second (simulating a long-running operation)
    val result = "Processed $input"
    // Once done, invoke the callback with the result
    callback.invoke(result) // This is equivalent to callback(result)
}

private fun main() = runBlocking {
    // Define a callback function
    val myCallback: (String) -> Unit = { result ->
        println("result: $result")
    }

    println("start")

    // Launch a coroutine for the first operation
    launch {
        performOperationWithCallback("Hello", myCallback)
    }

    // For demonstration, we'll wait a bit before launching the second operation
    delay(500) // Wait half a second

    // Launch another coroutine for the second operation
    launch {
        performOperationWithCallback("World") { result ->
            println("Lambda says: $result")
        }
    }

    println("end")
}
