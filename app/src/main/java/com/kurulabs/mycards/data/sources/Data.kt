package com.kurulabs.mycards.data.sources

import com.kurulabs.mycards.data.models.UserDataApi
import com.kurulabs.mycards.ui.cards.models.CardActionItem.CardAction.ActivateCard
import com.kurulabs.mycards.ui.cards.models.CardActionItem.CardAction.CancelCard
import com.kurulabs.mycards.ui.cards.models.CardActionItem.CardAction.CardLimits
import com.kurulabs.mycards.ui.cards.models.CardActionItem.CardAction.OrderCard
import com.kurulabs.mycards.ui.cards.models.CardActionItem.CardAction.PinChange
import com.kurulabs.mycards.ui.cards.models.CardData
import com.kurulabs.mycards.ui.cards.models.CardType.CREDIT
import com.kurulabs.mycards.ui.cards.models.CardType.DEBIT

val actionList by lazy {
    listOf(
        demoCreditActions,
        demoInactiveCreditActions,
        demoDebitActions
    )
}

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

val demoUsers = listOf(
    UserDataApi("John Smith"),
    UserDataApi("Max Musterman"),
    UserDataApi("Carolina Saez Piñeiro"),
    UserDataApi("Juan Jesus Mora Valenzuela"),
    UserDataApi("Serafin Alonso Singh"),
)