package com.kurulabs.mycards.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.kurulabs.mycards.ui.demo.getDemoCards

class CardViewModel : ViewModel() {
    var cards by mutableStateOf(getDemoCards())

    var actions by mutableStateOf(cards.first().actions)

    fun setActions(index: Int) {
        actions = cards[index].actions
    }
}