package com.kurulabs.mycards.data.repositories

import com.kurulabs.mycards.data.models.BankDataApi
import com.kurulabs.mycards.data.models.CardDataApi
import com.kurulabs.mycards.data.models.UserDataApi
import com.kurulabs.mycards.data.sources.actionList
import com.kurulabs.mycards.ui.cards.models.CardActionItem
import com.kurulabs.mycards.ui.cards.models.CardData
import com.kurulabs.mycards.ui.cards.models.CardType
import kotlin.random.Random

class CardsMapperImpl : CardsMapper {
    override fun map(
        cardData: List<CardDataApi>,
        bankData: List<BankDataApi>,
        userData: List<UserDataApi>
    ): List<CardData> {
        return cardData.mapIndexed { index, cardDataApi ->
            CardData(
                bankName = bankData[index].entity,
                typeName = getCardType(),
                number = cardDataApi.cardFormatted,
                validDate = cardDataApi.expirationDate,
                owner = userData[index].fullname,
                actions = getCardActions()
            )
        }
    }

    private fun getCardActions(): List<CardActionItem.CardAction> {
        return actionList[Random.nextInt(0, 2)]
    }

    private fun getCardType(): CardType = if (Random.nextBoolean())
        CardType.CREDIT
    else
        CardType.DEBIT
}
