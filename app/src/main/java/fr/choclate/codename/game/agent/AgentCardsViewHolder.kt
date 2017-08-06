package fr.choclate.codename.game.agent

import android.view.View
import fr.choclate.codename.game.CardModel
import fr.choclate.codename.game.CardsViewHolder
import kotlinx.android.synthetic.main.item_agent_card.view.*

class AgentCardsViewHolder(view: View): CardsViewHolder(view) {
    override fun setColor(card: CardModel) {
        val color = getColor(card)

        itemView.apply {
            wordTextView.setTextColor(color)
            reversedWordTextView.setTextColor(color)
        }
    }

    override fun setText(card: CardModel) {
        itemView.apply {
            wordTextView.text = card.word
            reversedWordTextView.text = card.word
        }
    }


}