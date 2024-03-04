package org.example.lateinit

private fun main() {
    repeat(10){
        lateinitValue()
    }
}

private fun lateinitValue(){
    lateinit var text: String
    //lateinit var number : Int Primitive Type (Int, Float, Double, Long 등)  (X)
    // 대충 중간에 뭔가 했음
    val result1 = 30

    text = "Result : $result1"
    println(text)

    // 대충 뭔가 또 했음
    val result2 = 50

    text = "Result : ${result1 + result2}"
    println(text)
}