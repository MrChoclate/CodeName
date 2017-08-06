package fr.choclate.codename.game

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View

abstract class CardsViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
    protected lateinit var card: CardModel
    protected lateinit var listener: OnCardClick

    fun bind(card: CardModel, listener: OnCardClick) {
        this.card = card
        this.listener = listener

        setText(card)
        setColor(card)
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        listener.onCardClick(card)
    }

    protected fun getColor(card: CardModel): Int {
        val colorId = if (!card.isFound) android.R.color.black else
            when (card.color) {
                Team.RED -> android.R.color.holo_red_light
                Team.BLUE -> android.R.color.holo_blue_light
                Team.KILLER -> android.R.color.holo_purple
                else -> android.R.color.darker_gray
            }

        val color = ContextCompat.getColor(itemView.context, colorId)

        return color
    }

    abstract protected fun setColor(card: CardModel)

    abstract protected fun setText(card: CardModel)
}