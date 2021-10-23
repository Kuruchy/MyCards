package com.kurulabs.mycards.demo

import com.kurulabs.mycards.model.CardData
import com.kurulabs.mycards.model.CardLimits
import com.kurulabs.mycards.model.GiroIcon
import com.kurulabs.mycards.model.OrderCard
import com.kurulabs.mycards.model.VisaIcon


internal fun getDemoCards() = listOf(
    CardData("xxxx xxxx xxxx 3333", "Gandalf the Gray", GiroIcon),
    CardData("xxxx xxxx xxxx 4444", "Gandalf the White", VisaIcon)
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