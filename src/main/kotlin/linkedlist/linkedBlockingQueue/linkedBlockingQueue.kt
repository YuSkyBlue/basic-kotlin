package org.example.linkedlist.linkedBlockingQueue

import java.util.concurrent.LinkedBlockingQueue

fun main() {
    val queue = LinkedBlockingQueue<String>()

    // Producer thread
    val producer = Thread {
        try {
            queue.put("Hello")
            Thread.sleep(1000) // Simulate some delay
            queue.put("World")
            Thread.sleep(1000)
            queue.put("from Kotlin")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    // Consumer thread
    val consumer = Thread {
        try {
            // Poll with timeout
            for (i in 1..3) {
                val message = queue.take() // Will wait for an element to become available
                println("Consumed: $message")
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    producer.start()
    consumer.start()

    // Wait for both threads to finish
    producer.join()
    consumer.join()
}
