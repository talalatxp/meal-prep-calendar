package com.talaniacodes.mealprepcalendar.presentation.spending_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.talaniacodes.mealprepcalendar.common.Constants
import com.talaniacodes.mealprepcalendar.domain.use_case.get_spending.GetSpendingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class SpendingDetailViewModel @Inject constructor(
    private val getSpendingUseCase: GetSpendingUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(SpendingDetailState())
    val state: State<SpendingDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_SPENDING_TYPE)?.let { spendingType ->
            getSpending(spendingType)
        }
    }

    private fun getSpending(spendingType: String) {
        getSpendingUseCase(spendingType).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SpendingDetailState(spending = result.data)
                }

                is Resource.Error -> {
                    _state.value = SpendingDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _state.value = SpendingDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}