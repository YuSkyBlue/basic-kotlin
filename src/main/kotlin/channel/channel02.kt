package org.example.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

suspend fun sendNumbers(channel1: Channel<Int>, channel2: Channel<Int>) {
    for (x in 1..5) {
        // Send the number to both channels
        channel1.send(x)
        channel2.send(x)
        delay(100) // Simulate some work
    }
    // Close both channels to indicate no more elements will be sent
    channel1.close()
    channel2.close()
}

suspend fun receiveNumber1(channel: Channel<Int>, receiverId: Int) {
    for (y in channel) { // Receive numbers from the channel
        println("Receiver $receiverId got: $y")
    }
}
suspend fun receiveNumber2(channel: Channel<Int>, receiverId: Int) {
    for(z in channel){
        println("Receiver $receiverId got: $z")
    }
}

fun main() : Unit = runBlocking {
    val channel1 = Channel<Int>() // Create a new channel for the first receiver
    val channel2 = Channel<Int>() // Create a new channel for the second receiver

    launch { sendNumbers(channel1, channel2) } // Launch a coroutine to send numbers
    launch { receiveNumber1(channel1, 1) } // Launch a coroutine for the first receiver
    launch { receiveNumber2(channel2, 2) } // Launch another coroutine for the second receiver
}
