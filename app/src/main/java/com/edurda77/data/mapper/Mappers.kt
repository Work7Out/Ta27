package com.edurda77.data.mapper

import com.edurda77.data.remote.LoanDto
import com.edurda77.domain.model.Loan

fun List<LoanDto>.mapToLoan(): List<Loan> {
    return this.map {
        Loan(
            imageUrl = it.imageUrl,
            percent = it.percent,
            sumOne = it.sumOne,
            url = it.url,
            termTo = it.termTo,
        )
    }
}
