package com.talaniacodes.mealprepcalendar.presentation.spending_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel

@Composable
fun SpendingListItem(
    spendingItem: SpendingModel,
    onSpendingCLick: (SpendingModel) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSpendingCLick(spendingItem) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${spendingItem.id}. ${spendingItem.name} ",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis //si el texto es muy largo lo corta
        )
        Text(
            text = "${spendingItem.quantity}$",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.End,
            modifier = Modifier.align(CenterVertically)
        )
    }

}