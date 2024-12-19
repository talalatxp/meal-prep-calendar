package com.talaniacodes.mealprepcalendar.presentation.spending_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.talaniacodes.mealprepcalendar.domain.use_case.get_spendings.GetSpendingsUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpendingListViewModel @Inject constructor(
    private val getSpendingsUseCase: GetSpendingsUseCaseImpl
) : ViewModel() {

    var state by mutableStateOf(SpendingListState())

    init {
        getSpendings()
    }

    fun onEvent(event: SpendingListEvent) {
        when (event) {
            is SpendingListEvent.OnSearchQueryChange -> onSearchQueryChangeEvent()
        }
    }

    private fun onSearchQueryChangeEvent() {

    }

    private fun getSpendings(
        query: String = state.searchQuery.lowercase()
    ) {
        viewModelScope.launch {
            getSpendingsUseCase(query).collect { result ->
                state = state.copy(spendings = result)
            }
        }
    }
}