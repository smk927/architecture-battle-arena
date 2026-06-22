package com.example.architecturebattlearena.common.architecture

import kotlinx.coroutines.flow.StateFlow

/**
 * Marker interface for UI State
 */
interface UiState

/**
 * Marker interface for User Intent/Action
 */
interface UiIntent

/**
 * Marker interface for Side Effects (Navigation, Toast, etc.)
 */
interface UiEffect

/**
 * Base contract for MVI ViewModels
 */
interface MviViewModel<S : UiState, I : UiIntent, E : UiEffect> {
    val uiState: StateFlow<S>
    fun onIntent(intent: I)
}
