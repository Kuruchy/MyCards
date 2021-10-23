package com.kurulabs.mycards

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kurulabs.mycards.demo.getDemoCards

class CardViewModel : ViewModel() {
    val cards = mutableStateOf(getDemoCards())
}