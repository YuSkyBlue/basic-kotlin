package org.example.operator


class CustomRange(private val start: Int, private val endInclusive: Int) {
    operator fun contains(value: Int): Boolean = value in start..endInclusive

    operator fun invoke(action: (Int) -> Unit) {
        for (i in start..endInclusive) {
            action(i)
        }
    }

    // Example of overloading plus and minus
    operator fun plus(increment: Int): CustomRange = CustomRange(start, endInclusive + increment)
    operator fun minus(decrement: Int): CustomRange = CustomRange(start, endInclusive - decrement)
}

fun main() {
    val myRange = CustomRange(1, 5)

    // Using invoke to perform an action for each number in the range
    myRange { number ->
        println("Number: $number")
    }

    // Checking if a number is in the range using contains
    if (4 in myRange) {
        println("4 is in the range.")
    }

    // Demonstrating plus and minus operators
    val extendedRange = myRange + 2
    val reducedRange = myRange - 1

    extendedRange { println("Extended: $it") }
    reducedRange { println("Reduced: $it") }
}
