package org.example.transaction

sealed class AuthEvent {
    object CreditAuth1 : AuthEvent()
    object CreditAuth2 : AuthEvent()
    object Cancel : AuthEvent()
}

enum class TransactionState {
    Idle, WaitingForAuth2, Auth1Completed, CancelledAfterAuth1
}

class TransactionManager {
    private var state = TransactionState.Idle

    fun processEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.CreditAuth1 -> handleCreditAuth1()
            is AuthEvent.CreditAuth2 -> handleCreditAuth2()
            is AuthEvent.Cancel -> handleCancel()
        }
    }

    private fun handleCreditAuth1() {
        if (state == TransactionState.Idle) {
            // Process creditAuth1
            state = TransactionState.Auth1Completed
            println("Processing CreditAuth1")
            // Assuming you might set a timer or something similar to transition to waiting for Auth2
            state = TransactionState.WaitingForAuth2
        }
    }

    private fun handleCreditAuth2() {
        when (state) {
            TransactionState.WaitingForAuth2 -> {
                println("Ignoring CreditAuth2 because it's too soon after CreditAuth1")
                // Optionally reset the state or handle as needed
            }
            TransactionState.CancelledAfterAuth1 -> {
                println("Processing CreditAuth2 after cancellation")
                // Process creditAuth2
                state = TransactionState.Idle // Reset state or set to a final state
            }
            else -> println("CreditAuth2 received in an unexpected state: $state")
        }
    }

    private fun handleCancel() {
        if (state == TransactionState.WaitingForAuth2 || state == TransactionState.Auth1Completed) {
            println("Cancel received after CreditAuth1")
            state = TransactionState.CancelledAfterAuth1
        }
    }
}

fun main() {
    val manager = TransactionManager()

    // Simulate receiving events
    manager.processEvent(AuthEvent.CreditAuth1)
    // Simulate a small delay
    Thread.sleep(1000) // This is just for demonstration; use coroutines or callbacks in real Android apps
    manager.processEvent(AuthEvent.Cancel)
    manager.processEvent(AuthEvent.CreditAuth2)
}