package org.example.test

import kotlinx.coroutines.delay
import java.time.Duration
import kotlinx.coroutines.*
import java.time.Instant

// Simulating a class that handles job codes
class JobProcessor {

    private var lastAuthCallTime: Instant? = null

    // Simulated function that processes job codes
    suspend fun processJobCode(jobCode: String) {
        val currentTime = Instant.now()

        val isTwicePacket = lastAuthCallTime?.let {
            val timeDiff = Duration.between(it, currentTime).toMillis()
            println("Auth TimeDiff: $timeDiff ms")
            if (timeDiff <= 1000) { // Check if the difference is less than or equal to 1 second
                true
            } else {
                false
            }
        } ?: false

        lastAuthCallTime = currentTime

        if (isTwicePacket) {
            println("Detected twice packet within 1 second. Introducing delay.")
            delay(3000) // Introduce a 3-second delay if the job code "B" is received twice within 1 second
        }

        // Here, you would put the rest of your job processing logic
        println("Processing job code: $jobCode")
    }
}

// Example usage
fun main() = runBlocking {
    val jobProcessor = JobProcessor()

    // Simulate receiving job code "B" twice within a short time frame
    println("jobcode frist call")
    jobProcessor.processJobCode("B") // First call
    println("jobcode seocnd call")
    jobProcessor.processJobCode("B") // Second call shortly after the first

    // Simulate receiving another job code "B" after some time (more than 1 second)
    delay(2000) // Wait for 2 seconds before the next call
    println("jobcode third call")
    jobProcessor.processJobCode("B") // Third call, should not introduce additional delay
}