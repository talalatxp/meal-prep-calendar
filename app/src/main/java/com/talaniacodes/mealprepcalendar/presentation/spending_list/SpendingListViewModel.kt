package com.talaniacodes.mealprepcalendar.presentation.spending_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.talaniacodes.mealprepcalendar.common.Resource
import com.talaniacodes.mealprepcalendar.domain.use_case.get_spendings.GetSpendingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SpendingListViewModel @Inject constructor(
    private val getSpendingsUseCase: GetSpendingsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SpendingListState())
    val state: State<SpendingListState> = _state

    init {
        getSpendings()
    }

    private fun getSpendings() {
        getSpendingsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SpendingListState(spendings = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        SpendingListState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = SpendingListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}