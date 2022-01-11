package com.kurulabs.mycards.demo

import com.kurulabs.mycards.model.cards.CardActionItem.CardAction.ActivateCard
import com.kurulabs.mycards.model.cards.CardActionItem.CardAction.CancelCard
import com.kurulabs.mycards.model.cards.CardActionItem.CardAction.CardLimits
import com.kurulabs.mycards.model.cards.CardActionItem.CardAction.GooglePay
import com.kurulabs.mycards.model.cards.CardActionItem.CardAction.OrderCard
import com.kurulabs.mycards.model.cards.CardActionItem.CardAction.PinChange
import com.kurulabs.mycards.model.cards.CardData
import com.kurulabs.mycards.model.cards.CardType.CREDIT
import com.kurulabs.mycards.model.cards.CardType.DEBIT

private val demoCreditActions = listOf(
    GooglePay,
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
    typeName = DEBIT,
    maskedNumber = "xxxx xxxx xxxx 3333",
    owner = "Gandalf the Gray",
    actions = demoDebitActions
)

private val demoCreditCard = CardData(
    typeName = CREDIT,
    maskedNumber = "xxxx xxxx xxxx 4444",
    owner = "Gandalf the White",
    actions = demoCreditActions
)

private val demoInactiveCreditCard = CardData(
    typeName = CREDIT,
    maskedNumber = "xxxx xxxx xxxx 4444",
    owner = "Saruman the White",
    actions = demoInactiveCreditActions
)

fun getDemoCards(): List<CardData> = listOf(
    demoDebitCard,
    demoCreditCard,
    demoInactiveCreditCard,
)