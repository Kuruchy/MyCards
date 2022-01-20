package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.ui.models.cards.CardActionItem.CardAction.ActivateCard
import com.kurulabs.mycards.ui.models.cards.CardActionItem.CardAction.CancelCard
import com.kurulabs.mycards.ui.models.cards.CardActionItem.CardAction.CardLimits
import com.kurulabs.mycards.ui.models.cards.CardActionItem.CardAction.OrderCard
import com.kurulabs.mycards.ui.models.cards.CardActionItem.CardAction.PinChange
import com.kurulabs.mycards.ui.models.cards.CardData
import com.kurulabs.mycards.ui.models.cards.CardType.CREDIT
import com.kurulabs.mycards.ui.models.cards.CardType.DEBIT

private val demoCreditActions = listOf(
    CardLimits,
    OrderCard,
    CancelCard,
    PinChange,
)

private val demoInactiveCreditActions = listOf(
    ActivateCard,
)

private val demoDebitActions = listOf(
    CardLimits,
    OrderCard,
    CancelCard,
    PinChange,
)

private val demoDebitCard = CardData(
    bankName = "Wizard Bank",
    typeName = DEBIT,
    number = "1234 5678 9000 1234",
    validDate = "12/24",
    owner = "Gandalf the Gray",
    actions = demoDebitActions
)

private val demoCreditCard = CardData(
    bankName = "Wizard Bank",
    typeName = CREDIT,
    number = "5678 9012 3456 7890",
    validDate = "12/26",
    owner = "Gandalf the White",
    actions = demoCreditActions
)

private val demoInactiveCreditCard = CardData(
    bankName = "Wizard Bank",
    typeName = CREDIT,
    number = "5678 9012 7890 9999",
    validDate = "10/25",
    owner = "Saruman the White",
    actions = demoInactiveCreditActions
)

fun getDemoCards(): List<CardData> = listOf(
    demoCreditCard,
    demoDebitCard,
    demoInactiveCreditCard,
)