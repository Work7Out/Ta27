package com.edurda77.data.repository

import com.edurda77.data.mapper.mapToLoan
import com.edurda77.data.remote.ApiTa
import com.edurda77.domain.model.Loan
import com.edurda77.domain.repository.TaRepository
import com.edurda77.domain.utils.Resource
import javax.inject.Inject

class TaRepositoryImpl @Inject constructor(private val apiTa: ApiTa) : TaRepository {
    override suspend fun getRemoteData(): Resource<List<Loan>> {
        return try {
            val result = apiTa.getData()
            Resource.Success(
                result.mapToLoan()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error")
        }
    }
}