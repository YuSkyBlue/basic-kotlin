package org.example.generic

class Box<T>(t: T) {
    var value = t
}

// Usage
val intBox = Box(1)
val stringBox = Box("Hello")

private fun main(){
    println(intBox.value)
    println(stringBox.value)
}