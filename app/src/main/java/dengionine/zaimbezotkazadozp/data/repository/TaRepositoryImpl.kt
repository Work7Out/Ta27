package dengionine.zaimbezotkazadozp.data.repository

import dengionine.zaimbezotkazadozp.data.mapper.mapToLoan
import dengionine.zaimbezotkazadozp.data.remote.ApiTa
import dengionine.zaimbezotkazadozp.domain.model.Loan
import dengionine.zaimbezotkazadozp.domain.repository.TaRepository
import dengionine.zaimbezotkazadozp.domain.utils.Resource
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