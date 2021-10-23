package com.kurulabs.mycards.model

import androidx.annotation.DrawableRes
import com.kurulabs.mycards.R

sealed class CardIcon(@DrawableRes val res: Int)
object VisaIcon : CardIcon(R.drawable.ic_card_visa)
object GiroIcon : CardIcon(R.drawable.ic_card_giro)
