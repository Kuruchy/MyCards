package com.kurulabs.mycards.model

internal data class CardData(
    val typeName: String,
    val maskedNumber: String,
    val owner: String,
    val icon: CardIcon
)
