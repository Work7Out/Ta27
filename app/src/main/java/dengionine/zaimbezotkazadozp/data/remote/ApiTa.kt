package dengionine.zaimbezotkazadozp.data.remote

import retrofit2.http.GET

interface ApiTa {
    @GET("alexofyou/llz/main/newapis")
    suspend fun getData() : List<LoanDto>
}