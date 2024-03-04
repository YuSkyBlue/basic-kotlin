package org.example.test

import java.time.Duration
import java.time.LocalDateTime

private fun main(){
     var packet1Time: LocalDateTime? = null
     var packet2Time: LocalDateTime? = null

    packet1Time = LocalDateTime.now()
    Thread.sleep(1000)
    packet2Time = LocalDateTime.now()

     val duration1 = Duration.between(packet1Time, packet2Time).abs()
    val duration2= Duration.between(packet2Time, packet1Time).abs()
    println(duration1.seconds)
    println(duration2.seconds)
    println(duration1.toMillis())
    println(duration2.toMillis())
    if(duration1.toMillis() <= 1000){
        println("1초보다 작음")
    } else {
        println("1초보다 큼")
    }
 }