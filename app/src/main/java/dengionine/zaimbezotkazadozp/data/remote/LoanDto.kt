package dengionine.zaimbezotkazadozp.data.remote


import com.google.gson.annotations.SerializedName

data class LoanDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("icon")
    val imageUrl: String,
    @SerializedName("sum")
    val sumOne: Int,
    @SerializedName("url")
    val url: String
)