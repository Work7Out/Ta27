package com.edurda77.ui

sealed interface AppState {
    data object Loading : AppState
    data object Error : AppState
    data object Success : AppState
    class Web(val url: String) : AppState
}