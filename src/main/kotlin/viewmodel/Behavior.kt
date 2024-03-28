package viewmodel

interface Behavior {
    fun doSomething()
}

class App1Behavior : Behavior {
    override fun doSomething() {
        println("Doing something the App1 way.")
    }
}

class App2Behavior : Behavior {
    override fun doSomething() {
        println("Doing something the App2 way.")
    }
}
class SharedViewModel(private val behavior: Behavior) {
    fun doSomething() {
        behavior.doSomething()
    }
}

fun main() {
    val app1ViewModel = SharedViewModel(App1Behavior())
    val app2ViewModel = SharedViewModel(App2Behavior())

    println("Using App1's ViewModel:")
    app1ViewModel.doSomething()

    println("\nUsing App2's ViewModel:")
    app2ViewModel.doSomething()
}