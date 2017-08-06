package fr.choclate.codename.game.agent

import android.view.LayoutInflater
import android.view.ViewGroup
import fr.choclate.codename.R
import fr.choclate.codename.game.CardsAdapter
import fr.choclate.codename.game.OnCardClick

class AgentCardsAdapter(listener: OnCardClick): CardsAdapter(listener) {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AgentCardsViewHolder {
        val context = parent!!.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_agent_card, parent, false)
        return AgentCardsViewHolder(view)
    }
}
