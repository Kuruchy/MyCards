package com.kurulabs.mycards

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kurulabs.mycards.demo.getDemoCards
import com.kurulabs.mycards.model.CardData

class CardViewModel : ViewModel() {
    var cards = mutableStateOf(getDemoCards())
        private set

    var actions = mutableStateOf(cards.value.first().actions)
        private set

    fun setActions(index: Int) {
        actions.value = cards.value[index].actions
    }
}