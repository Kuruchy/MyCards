package com.kurulabs.mycards.ui.models.cards

import androidx.annotation.DrawableRes
import com.kurulabs.mycards.R
import com.kurulabs.mycards.ui.models.cards.CardActionItem.GroupTitle.CardGroupTitle
import com.kurulabs.mycards.ui.models.cards.CardActionItem.GroupTitle.PayGroupTitle
import com.kurulabs.mycards.ui.models.cards.CardActionItem.GroupTitle.PinGroupTitle

sealed class CardActionItem {
    open class GroupTitle(
        val index: Int,
        val title: String
    ) : CardActionItem() {

        object PayGroupTitle : GroupTitle(index = 0, title = "Payment")

        object CardGroupTitle : GroupTitle(index = 1, title = "Card Management")

        object PinGroupTitle : GroupTitle(index = 2, title = "PIN Management")
    }

    open class CardAction(
        val name: String,
        val description: String,
        @DrawableRes val icon: Int,
        val groupTitle: GroupTitle,
    ) : CardActionItem() {

        object GooglePay : CardAction(
            name = "Google Pay",
            description = "Configure your Google Pay",
            icon = R.drawable.ic_contactless,
            groupTitle = PayGroupTitle,
        )

        object CardLimits : CardAction(
            name = "Card Limits",
            description = "Change the Weekly and Daily Limit",
            icon = R.drawable.ic_attach_money,
            groupTitle = PayGroupTitle,
        )

        object ActivateCard : CardAction(
            name = "Activate Card",
            description = "New Card? Activate it here",
            icon = R.drawable.ic_credit_score,
            groupTitle = CardGroupTitle,
        )

        object OrderCard : CardAction(
            name = "Order Card",
            description = "Order a replacement of this card",
            icon = R.drawable.ic_credit_card,
            groupTitle = CardGroupTitle,
        )

        object CancelCard : CardAction(
            name = "Cancel Card",
            description = "Did you loose your card? Cancel it here",
            icon = R.drawable.ic_credit_card_off,
            groupTitle = CardGroupTitle,
        )

        object PinChange : CardAction(
            name = "Change Pin",
            description = "Have you forgotten your pin? Change it here",
            icon = R.drawable.ic_pin,
            groupTitle = PinGroupTitle,
        )
    }
}