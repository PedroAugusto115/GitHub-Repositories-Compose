package com.ppereira.feature_repos.presentation.model

import com.ppereira.feature_repos.model.Page

sealed class UiState {
    data object Loading : UiState()
    data object Error : UiState()
    data class Success(val results: Page) : UiState()
    data object Empty : UiState()
}