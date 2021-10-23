package com.kurulabs.mycards.demo

import com.kurulabs.mycards.model.CardData
import com.kurulabs.mycards.model.CardAction.CardLimits
import com.kurulabs.mycards.model.CardAction.OrderCard
import com.kurulabs.mycards.model.CardIcon.GiroIcon
import com.kurulabs.mycards.model.CardIcon.VisaIcon

private val demoGiro = CardData(
    typeName = "girocard",
    maskedNumber = "xxxx xxxx xxxx 3333",
    owner = "Gandalf the Gray",
    icon = GiroIcon
)
private val demoVisa = CardData(
    typeName = "VISA Card",
    maskedNumber = "xxxx xxxx xxxx 4444",
    owner = "Gandalf the White",
    icon = VisaIcon
)

internal fun getDemoCards() = listOf(
    demoGiro,
    demoVisa
)

internal fun getDemoActions() = listOf(
    OrderCard,
    CardLimits,
    OrderCard,
    CardLimits,
    OrderCard,
    CardLimits,
    OrderCard,
    CardLimits,
)