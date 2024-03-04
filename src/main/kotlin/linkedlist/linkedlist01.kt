package org.example.linkedlist

import java.util.LinkedList
import java.util.Queue

fun main() {
    val myQueue: Queue<String?> = LinkedList()
    val sideQueue: Queue<String?> = LinkedList()
    // Adding elements to the queue
    myQueue.add("First")
    myQueue.add("Second")
    myQueue.add(null) // Adding a null case
    myQueue.add("Third")

    println("Queue after adding elements: $myQueue")

    // Polling (retrieving and removing) the first element of the queue
    val polledElement = myQueue.poll()
    println("Polled element: $polledElement")
    println("Queue after polling: $myQueue")

    sideQueue.add(polledElement)
    println("sideQueue after polling: $sideQueue")
    // Peeking (retrieving without removing) at the first element of the queue
    val peekedElement = myQueue.peek()
    println("Peeked element: $peekedElement")
    println("Queue after peeking: $myQueue")

    // Example of handling null case gracefully
    while (true) {
        val element = myQueue.poll()
        if (element != null) {
            println("Processing element: $element")
        } else {
            Thread.sleep(1000)
            println("Encountered null element, handling gracefully.")
        }
    }
}

