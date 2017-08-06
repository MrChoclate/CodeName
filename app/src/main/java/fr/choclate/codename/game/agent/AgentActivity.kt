package fr.choclate.codename.game.agent

import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import fr.choclate.codename.BaseActivity
import fr.choclate.codename.R
import fr.choclate.codename.game.CardModel
import fr.choclate.codename.game.OnCardClick
import fr.choclate.codename.game.Team
import kotlinx.android.synthetic.main.activity_agent.*
import javax.inject.Inject


class AgentActivity : BaseActivity(), AgentViewContract, OnCardClick {
    @Inject lateinit var presenter: AgentPresenter
    private val adapter = AgentCardsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDefaultComponent().inject(this)
        setContentView(R.layout.activity_agent)

        presenter.create(this, intent.extras)

        cardsGridView.layoutManager = GridLayoutManager(this, 5)
        cardsGridView.adapter = adapter
        skipButton.setOnClickListener { onSkipClick() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    private fun onSkipClick() {
        presenter.skipClick()
    }

    override fun displayTeamScore(blueScore: Int, redScore: Int) {
        redScoreTextView.text = getString(R.string.red_score, redScore)
        blueScoreTextView.text = getString(R.string.blue_score, blueScore)
    }

    override fun displayAgentCards(cards: List<CardModel>) {
        adapter.setCards(cards)
    }

    override fun displayTeamPlaying(teamPlaying: Team?) {
        if (teamPlaying == null) {
            skipButton.visibility = View.INVISIBLE
            return
        }

        val color =
            if (teamPlaying == Team.RED)
                android.R.color.holo_red_dark
            else
                android.R.color.holo_blue_dark

        skipButton.setTextColor(ContextCompat.getColor(this, color))
    }

    override fun onCardClick(card: CardModel) {
        presenter.cardClick(card)
    }
}