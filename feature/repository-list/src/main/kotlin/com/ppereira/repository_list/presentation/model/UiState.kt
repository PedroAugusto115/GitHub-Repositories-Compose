package com.ppereira.repository_list.presentation.model

import com.ppereira.repository_list.model.Page

sealed class UiState {
    data object Loading : UiState()
    data object Error : UiState()
    data class Success(val results: Page) : UiState()
    data object Empty : UiState()
}
