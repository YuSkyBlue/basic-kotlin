package org.example.callback

// Define a function that accepts a callback as its parameter
private fun performOperationWithCallback(input: String, callback: (result: String) -> Unit) {
    // Simulate some operation
    val result = "Processed $input"
    // Once done, invoke the callback with the result
    callback.invoke(result) // This is equivalent to callback(result)
}

private fun main() {
    // Define a callback function
    val myCallback: (String) -> Unit = { result ->
        println(result)
    }
    println("start")
    // Pass the callback function to the operation
    performOperationWithCallback("Hello", myCallback)
    println("end")
    // Or using a lambda directly
    performOperationWithCallback("World") { result ->
        println("Lambda says: $result")
    }
}
