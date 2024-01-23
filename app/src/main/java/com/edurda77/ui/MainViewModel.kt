package com.edurda77.ui

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.domain.model.Loan
import com.edurda77.domain.repository.TaRepository
import com.edurda77.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(VERSION_CODES.O)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: TaRepository
) : ViewModel() {
    private var _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()
    private var _baseLoans =  MutableStateFlow(emptyList<Loan>())

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            when (val resultLoad = repository.getRemoteData()) {
                is Resource.Error -> {
                    _state.value.copy(
                        error = resultLoad.message,
                        isLoading = false
                    )
                        .updateStateUI()
                }
                is Resource.Success -> {
                    val loans = resultLoad.data?: emptyList()
                    _state.value.copy(
                        moneyList = loans,
                        isLoading = false,
                    )
                        .updateStateUI()
                    _baseLoans.value = loans
                }
            }
        }
    }

    private fun MainState.updateStateUI() {
        _state.update {
            this
        }
    }
}