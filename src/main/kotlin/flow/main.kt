package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

private fun main() = runBlocking<Unit> {
    val viewModel = ContributorsViewModel()
    val job = launch {
        viewModel.uiState.collect { uiState ->
            println(uiState)
        }
    }

    launch {
        viewModel.errorFlow.collect { error ->
            println("Error: ${error.message}")
        }
    }

    delay(10000) // Wait a bit before finishing to see the output
    job.cancel() // Cancel the collecting job
    println("finished")
}

class ContributorsViewModel : CoroutineScope by CoroutineScope(Dispatchers.Default) {
    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow: SharedFlow<Throwable> get() = _errorFlow

    val uiState: StateFlow<ContributorsUiState> =
        flow { emit(getContributorsUseCase().toList()) }
            .map(ContributorsUiState::Contributors)
            .catch { throwable -> _errorFlow.emit(throwable) }
            .stateIn(
                scope = this,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = ContributorsUiState.Loading
            )
}

fun getContributorsUseCase(): Flow<String> = flow {
    emit("John Doe") // Simulate fetching data
    delay(500) // Simulate network delay
    emit("Jane Smith")
}

sealed class ContributorsUiState {
    object Loading : ContributorsUiState()
    data class Contributors(val contributors: List<String>) : ContributorsUiState()
}