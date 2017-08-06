package fr.choclate.codename.game.spymaster

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import fr.choclate.codename.BaseActivity
import fr.choclate.codename.R
import fr.choclate.codename.game.CardModel
import fr.choclate.codename.game.OnCardClick
import kotlinx.android.synthetic.main.activity_spy_master.*
import javax.inject.Inject

class SpyMasterActivity : BaseActivity(), SpyMasterViewContract, OnCardClick {

    @Inject lateinit var presenter: SpyMasterPresenter

    private val adapter = SpyMasterCardsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spy_master)
        getDefaultComponent().inject(this)

        presenter.create(this, intent.extras)

        cardsGridView.layoutManager = GridLayoutManager(this, 5)
        cardsGridView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun onCardClick(card: CardModel) {
        // TODO: nullable listener
    }

    override fun displaySpyMasterCards(cards: List<CardModel>) {
        adapter.setCards(cards)
    }
}
