package dengionine.zaimbezotkazadozp.data.mapper

import dengionine.zaimbezotkazadozp.data.remote.LoanDto
import dengionine.zaimbezotkazadozp.domain.model.Loan

fun List<LoanDto>.mapToLoan(): List<Loan> {
    return this.map {
        Loan(
            imageUrl = it.imageUrl,
            sumOne = it.sumOne,
            url = it.url,
            name = it.name
        )
    }
}
