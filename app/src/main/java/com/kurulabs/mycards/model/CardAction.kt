package com.kurulabs.mycards.model

import androidx.annotation.DrawableRes
import com.kurulabs.mycards.R

sealed class CardActionItem {
    open class GroupTitle(
        val title: String
    ) : CardActionItem() {
        object PayTitle : GroupTitle("Payment")
        object CardTitle : GroupTitle("Card Management")
        object PinTitle : GroupTitle("PIN Management")
    }

    open class CardAction(
        val title: String,
        val subtitle: String,
        @DrawableRes val icon: Int
    ) : CardActionItem() {

        object GooglePay : CardAction(
            title = "Google Pay",
            subtitle = "Configure your Google Pay",
            icon = R.drawable.ic_contactless
        )

        object ActivateCard : CardAction(
            title = "Activate Card",
            subtitle = "New Card? Activate it here",
            icon = R.drawable.ic_credit_score
        )

        object OrderCard : CardAction(
            title = "Order Card",
            subtitle = "Order a replacement of this card",
            icon = R.drawable.ic_credit_card
        )

        object CancelCard : CardAction(
            title = "Cancel Card",
            subtitle = "Did you loose your card? Cancel it here",
            icon = R.drawable.ic_credit_card_off
        )

        object CardLimits : CardAction(
            title = "Card Limits",
            subtitle = "Change the Weekly and Daily Limit",
            icon = R.drawable.ic_attach_money
        )

        object PinChange : CardAction(
            title = "Change Pin",
            subtitle = "Have you forgotten your pin? Change it here",
            icon = R.drawable.ic_pin
        )
    }
}
