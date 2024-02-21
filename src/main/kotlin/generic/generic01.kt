package org.example.generic

fun <T> swap(pair: Pair<T, T>): Pair<T, T> {
    return pair.second to pair.first
}

// Usage
val intPair = swap(Pair(1, 2)) // Outputs (2, 1)
val stringPair = swap(Pair("Hello", "World")) // Outputs ("World", "Hello")

private fun main(){
    println(intPair)
    println(stringPair)
}