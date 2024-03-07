package org.example.test

import kotlinx.coroutines.*

private var paymentJob: Job? = null
private fun main() = runBlocking {
    repeat(5){
        delay(100)
        payment()
    }

}


suspend fun payment() {
    println("paymentJob Start")
    authCancelJob()
    paymentJob = CoroutineScope(Dispatchers.IO).launch {
        try {
            while (isActive) {
                println("1.paymentJob Processing")
                delay(5000)
                println("2.paymentJob Processing")
                break
            }
            authCancelJob()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

private fun authCancelJob() {
    paymentJob?.let { job ->
        if (job.isActive) {
            job.cancel()
        }
    }
}