package org.example.callback

private fun performOperation(callback: () -> Unit) {
    println("Performing operation...")
    callback.invoke() // Invoke the callback function
    println("Operation completed.")
}

private fun main() {
    var retry = 0
    while(retry <3)
    performOperation {
        retry++
        println("Inside lambda")
        Thread.sleep(3000)
        println(retry)
        return@performOperation // Return from the lambda to the performOperation function
        println("This line won't be executed")
    }
    println("After operation")
}