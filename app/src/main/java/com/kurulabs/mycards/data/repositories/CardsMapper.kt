package com.kurulabs.mycards.data.repositories

import com.kurulabs.mycards.data.models.CardDataApi
import com.kurulabs.mycards.ui.cards.models.CardData

interface CardsMapper {
    fun map(usersData: List<CardDataApi>): List<CardData>
}
