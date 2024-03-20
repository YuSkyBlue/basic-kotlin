package org.example.Inheritance.kotlin.basic

private open class ParentClass {
    constructor() {
        println("ParentClass constructor called")
    }
    
    constructor(message: String) {
        println("ParentClass constructor called with message: $message")
    }
}

private class ChildClass : ParentClass {
    constructor() : super() { // Calls the default constructor of the parent class
        println("ChildClass constructor called")
    }
    
    constructor(message: String) : super(message) { // Calls the parent constructor with a parameter
        println("ChildClass constructor called with message: $message")
    }
}
private fun main(){
    val child = ChildClass()
    val child1 = ChildClass("Kavein")
}