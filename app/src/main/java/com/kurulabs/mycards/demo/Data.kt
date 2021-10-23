package com.kurulabs.mycards.demo

import com.kurulabs.mycards.model.CardActionItem.CardAction.ActivateCard
import com.kurulabs.mycards.model.CardActionItem.CardAction.CancelCard
import com.kurulabs.mycards.model.CardActionItem.CardAction.CardLimits
import com.kurulabs.mycards.model.CardActionItem.CardAction.GooglePay
import com.kurulabs.mycards.model.CardActionItem.CardAction.OrderCard
import com.kurulabs.mycards.model.CardActionItem.CardAction.PinChange
import com.kurulabs.mycards.model.CardData
import com.kurulabs.mycards.model.CardIcon.GiroIcon
import com.kurulabs.mycards.model.CardIcon.VisaIcon

private val demoVisaActions = listOf(
    GooglePay,
    CardLimits,
    OrderCard,
    CancelCard,
    PinChange,
)

private val demoInactiveVisaActions = listOf(
    ActivateCard,
)

private val demoGiroActions = listOf(
    CardLimits,
    OrderCard,
    CancelCard,
    PinChange,
)

private val demoGiro = CardData(
    typeName = "girocard",
    maskedNumber = "xxxx xxxx xxxx 3333",
    owner = "Gandalf the Gray",
    icon = GiroIcon,
    actions = demoGiroActions
)

private val demoVisa = CardData(
    typeName = "VISA Card",
    maskedNumber = "xxxx xxxx xxxx 4444",
    owner = "Gandalf the White",
    icon = VisaIcon,
    actions = demoVisaActions
)

private val demoInactiveVisa = CardData(
    typeName = "VISA Card",
    maskedNumber = "xxxx xxxx xxxx 4444",
    owner = "Saruman the White",
    icon = VisaIcon,
    actions = demoInactiveVisaActions
)

fun getDemoCards(): List<CardData> = listOf(
    demoGiro,
    demoVisa,
    demoInactiveVisa,
)