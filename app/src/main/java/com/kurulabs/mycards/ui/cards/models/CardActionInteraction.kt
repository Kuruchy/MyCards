package com.kurulabs.mycards.ui.cards.models

sealed class CardActionInteraction

object SwipeToInteract: CardActionInteraction()
object PressToInteract: CardActionInteraction()
