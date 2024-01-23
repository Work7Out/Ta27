package com.edurda77.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edurda77.R
import com.edurda77.domain.model.Loan

@Composable
fun SuccessScreen(
    modifier: Modifier = Modifier,
    scrollState: LazyListState,
    loans: List<Loan>,
    goToWeb: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(10.dp)
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = stringResource(id = R.string.send),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onPrimary
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = modifier.height(10.dp))
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            state = scrollState ) {
            items(loans) {loan->
                ItemLoan(
                    imagePath = loan.imageUrl,
                    maxSum = loan.sumOne,
                    onClick = { goToWeb(loan.url) }
                )
            }
        }
    }
}