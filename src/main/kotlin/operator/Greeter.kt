package org.example.operator

class Greeter(private val greeting : String) {
    operator fun invoke(name:String){
        println("$greeting, $name")
    }
}

private fun main(){
    val greeter = Greeter("HELLO")
    greeter("World")
}