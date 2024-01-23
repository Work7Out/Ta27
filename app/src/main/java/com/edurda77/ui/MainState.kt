package com.edurda77.ui

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import com.edurda77.domain.model.Loan

@RequiresApi(VERSION_CODES.O)
data class MainState(
    val moneyList: List<Loan> = emptyList(),
    val error: String? = null,
    val isLoading: Boolean = true,
)
