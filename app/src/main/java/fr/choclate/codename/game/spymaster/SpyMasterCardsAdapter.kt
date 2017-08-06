package fr.choclate.codename.game.spymaster

import android.view.LayoutInflater
import android.view.ViewGroup
import fr.choclate.codename.R
import fr.choclate.codename.game.CardsAdapter
import fr.choclate.codename.game.OnCardClick

class SpyMasterCardsAdapter(listener: OnCardClick): CardsAdapter(listener) {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SpyMasterCardViewHolder {
        val context = parent!!.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_spy_master_card, parent, false)
        return SpyMasterCardViewHolder(view)
    }
}