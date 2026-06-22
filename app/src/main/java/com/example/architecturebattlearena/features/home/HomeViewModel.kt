package com.example.architecturebattlearena.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturebattlearena.domain.model.ArchitectureStats
import com.example.architecturebattlearena.domain.repository.BattleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class HomeUiState(
    val stats: List<ArchitectureStats> = emptyList(),
    val isLoading: Boolean = false
)

class HomeViewModel(
    private val repository: BattleRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadStats()
    }

    private fun loadStats() {
        viewModelScope.launch {
            _uiState.value = HomeUiState(isLoading = true)
            val stats = repository.getArchitectureStats()
            _uiState.value = HomeUiState(stats = stats, isLoading = false)
        }
    }
}
