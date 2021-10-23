package com.kurulabs.mycards.demo

import com.kurulabs.mycards.model.CardActionItem
import com.kurulabs.mycards.model.CardActionItem.CardAction.ActivateCard
import com.kurulabs.mycards.model.CardActionItem.CardAction.CancelCard
import com.kurulabs.mycards.model.CardActionItem.CardAction.CardLimits
import com.kurulabs.mycards.model.CardActionItem.CardAction.GooglePay
import com.kurulabs.mycards.model.CardActionItem.CardAction.OrderCard
import com.kurulabs.mycards.model.CardActionItem.CardAction.PinChange
import com.kurulabs.mycards.model.CardActionItem.GroupTitle.CardTitle
import com.kurulabs.mycards.model.CardActionItem.GroupTitle.PayTitle
import com.kurulabs.mycards.model.CardActionItem.GroupTitle.PinTitle
import com.kurulabs.mycards.model.CardData
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
    PayTitle,
    GooglePay,
    CardLimits,
    CardTitle,
    ActivateCard,
    OrderCard,
    CancelCard,
    PinTitle,
    PinChange,
)