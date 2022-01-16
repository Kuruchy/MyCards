package com.kurulabs.mycards.ui.models.cards

sealed class CardActionInteraction

object SwipeToInteract: CardActionInteraction()
object PressToInteract: CardActionInteraction()
