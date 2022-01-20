package com.kurulabs.mycards.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kurulabs.mycards.data.repositories.CardsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val cardsRepository: CardsRepository
) : ViewModel() {

    var cardsState = MutableStateFlow(CardsState(isLoading = true))
        private set

    var cardDetailState = MutableStateFlow(CardDetailState(isLoading = true))
        private set

    init {
        refreshCards()

        viewModelScope.launch {
            cardsRepository.observableCards().collect { cards ->
                cardsState.update { it.copy(cards = cards.toList()) }
            }
        }
    }

    private fun refreshCards() {
        cardsState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val cardsDeferred = async { cardsRepository.getAllCards() }

            val cards = cardsDeferred.await().getOrNull() ?: emptyList()

            cardsState.update {
                it.copy(
                    isLoading = false,
                    cards = cards
                )
            }
        }
    }
}