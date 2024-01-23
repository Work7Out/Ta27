package com.edurda77.data.mapper

import com.edurda77.data.remote.LoanDto
import com.edurda77.domain.model.Loan

fun List<LoanDto>.mapToLoan(): List<Loan> {
    return this.map {
        Loan(
            imageUrl = it.imageUrl,
            sumOne = it.sumOne,
            url = it.url
        )
    }
}
