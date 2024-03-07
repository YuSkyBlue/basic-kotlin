package channel


import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

private suspend fun sendNumbers(channel: Channel<Int>) {
    for (x in 1..5) {
        channel.send(x) // Send numbers 1 to 5 to the channel
        delay(100) // Simulate some work
    }
    channel.close() // Close the channel to indicate no more elements will be sent
}

private suspend fun receiveNumbers(channel: Channel<Int>) {
    for (y in channel) { // Receive numbers from the channel
        println(y)
    }
}

private fun main() : Unit = runBlocking {
    val channel = Channel<Int>() // Create a new channel
    launch { sendNumbers(channel) } // Launch a coroutine to send numbers
    launch { receiveNumbers(channel) } // Launch another coroutine to receive and print numbers
}
