package fr.choclate.codename.game.spymaster

import android.view.View
import fr.choclate.codename.game.CardModel
import fr.choclate.codename.game.CardsViewHolder

import kotlinx.android.synthetic.main.item_spy_master_card.view.*

class SpyMasterCardViewHolder(view: View): CardsViewHolder(view) {
    override fun setColor(card: CardModel) {
        val color = getColor(card)

        itemView.wordTextView.setTextColor(color)
    }

    override fun setText(card: CardModel) {
        itemView.wordTextView.text = card.word
    }
}