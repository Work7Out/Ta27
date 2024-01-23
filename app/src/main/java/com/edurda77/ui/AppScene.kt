package com.edurda77.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppScene (
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val state = mainViewModel.state.collectAsState()
    val scrollState = rememberLazyListState()
    when (val result = state.value.appState) {
        AppState.Error -> {
            state.value.error?.let { ErrorScreen(error = it) }
        }
        AppState.Loading -> {
            LoadingScreen()
        }
        AppState.Success -> {
            SuccessScreen(
                scrollState = scrollState,
                loans = state.value.moneyList,
                goToWeb = mainViewModel::goToWeb)
        }
        is AppState.Web -> {
            WebViewScreen(
                url = result.url,
                onClick = { mainViewModel.backFromWeb()})
        }
    }
}