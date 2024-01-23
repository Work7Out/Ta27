package com.edurda77.domain.repository

import com.edurda77.domain.model.Loan
import com.edurda77.domain.utils.Resource

interface TaRepository {
    suspend fun getRemoteData(): Resource<List<Loan>>
}