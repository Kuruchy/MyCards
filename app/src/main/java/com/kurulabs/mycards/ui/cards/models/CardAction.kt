package com.kurulabs.mycards.ui.cards.models

import androidx.annotation.DrawableRes
import com.kurulabs.mycards.R
import com.kurulabs.mycards.ui.cards.models.CardActionItem.GroupTitle.CardGroupTitle
import com.kurulabs.mycards.ui.cards.models.CardActionItem.GroupTitle.PayGroupTitle
import com.kurulabs.mycards.ui.cards.models.CardActionItem.GroupTitle.PinGroupTitle

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
        val detailDescription: String,
        @DrawableRes val icon: Int,
        val groupTitle: GroupTitle,
        val interaction: CardActionInteraction,
        val interactionText: String,
    ) : CardActionItem() {

        object CardLimits : CardAction(
            name = "Card Limits",
            description = "Change the Weekly and Daily Limit",
            detailDescription = "Here you could set your Card's Weekly and Daily Limit",
            icon = R.drawable.ic_attach_money,
            groupTitle = PayGroupTitle,
            interaction = PressToInteract,
            interactionText = "Set your limits",
        )

        object ActivateCard : CardAction(
            name = "Activate Card",
            description = "New Card? Activate it here",
            detailDescription = "Hurrah you go a new Card! Activate it here",
            icon = R.drawable.ic_credit_score,
            groupTitle = CardGroupTitle,
            interaction = SwipeToInteract,
            interactionText = "Swipe to activate this Card",
        )

        object OrderCard : CardAction(
            name = "Order Card",
            description = "Order a replacement of this Card",
            detailDescription = "Order a replacement of this Card. The new Card will be sent to you",
            icon = R.drawable.ic_credit_card,
            groupTitle = CardGroupTitle,
            interaction = SwipeToInteract,
            interactionText = "Swipe to order a replacement",
        )

        object CancelCard : CardAction(
            name = "Cancel Card",
            description = "Did you loose your card?",
            detailDescription = "Did you lose your card? Cancel it here. Beware this can not be undone.",
            icon = R.drawable.ic_credit_card_off,
            groupTitle = CardGroupTitle,
            interaction = SwipeToInteract,
            interactionText = "Swipe to cancel this Card",
        )

        object PinChange : CardAction(
            name = "Change Pin",
            description = "Did you forgot your pin?",
            detailDescription = "Have you forgotten your pin? Change it here",
            icon = R.drawable.ic_pin,
            groupTitle = PinGroupTitle,
            interaction = PressToInteract,
            interactionText = "Choose your Pin",
        )
    }
}
