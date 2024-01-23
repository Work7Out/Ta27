package dengionine.zaimbezotkazadozp.ui

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import dengionine.zaimbezotkazadozp.domain.model.Loan

@RequiresApi(VERSION_CODES.O)
data class MainState(
    val moneyList: List<Loan> = emptyList(),
    val error: String? = null,
    val isLoading: Boolean = true,
    val appState: AppState = AppState.Loading
)
