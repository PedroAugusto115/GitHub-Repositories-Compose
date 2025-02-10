package com.ppereira.networking.ui

sealed class UiState {
    data object Loading : UiState()
    data object Error : UiState()
    data class Success<T>(val results: T) : UiState()
    data object Empty : UiState()
}
