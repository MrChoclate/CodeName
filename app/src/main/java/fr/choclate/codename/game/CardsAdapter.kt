package fr.choclate.codename.game

import android.support.v7.widget.RecyclerView

abstract class CardsAdapter(val listener: OnCardClick): RecyclerView.Adapter<CardsViewHolder>() {
    private val cards = mutableListOf<CardModel>()

    override fun onBindViewHolder(holder: CardsViewHolder?, position: Int) {
        holder!!.bind(getItem(position), listener)
    }

    private fun getItem(position: Int): CardModel {
        return cards[position]
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    fun setCards(newCards: List<CardModel>) {
        cards.clear()
        cards.addAll(newCards)
        notifyDataSetChanged()
    }
}

interface OnCardClick {
    fun onCardClick(card: CardModel)
}

