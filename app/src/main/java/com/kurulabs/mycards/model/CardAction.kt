package com.kurulabs.mycards.model

import androidx.annotation.DrawableRes
import com.kurulabs.mycards.R

sealed class CardAction(
    val title: String,
    val subtitle: String,
    @DrawableRes val icon: Int
) {

    object OrderCard: CardAction(
        "Order Card",
        "Order a replacement of this card",
        R.drawable.ic_credit_card
    )

    object CardLimits: CardAction(
        "Card Limits",
        "Change the Weekly and Daily Limit",
        R.drawable.ic_attach_money
    )
}
