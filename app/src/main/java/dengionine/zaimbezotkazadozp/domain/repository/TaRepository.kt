package dengionine.zaimbezotkazadozp.domain.repository

import dengionine.zaimbezotkazadozp.domain.model.Loan
import dengionine.zaimbezotkazadozp.domain.utils.Resource

interface TaRepository {
    suspend fun getRemoteData(): Resource<List<Loan>>
}