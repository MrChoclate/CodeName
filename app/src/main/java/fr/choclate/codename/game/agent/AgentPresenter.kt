package fr.choclate.codename.game.agent

import android.os.Bundle
import fr.choclate.codename.game.CardModel
import fr.choclate.codename.game.Game
import fr.choclate.codename.game.GameRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AgentPresenter @Inject constructor(
    private val gameRepository: GameRepository
) {
    private var game: Game? = null
    private var gameView: AgentViewContract? = null

    fun cardClick(card: CardModel) {
        game!!.play(card)
        updateView()
    }

    fun skipClick() {
        game!!.skipTeamTurn()
        gameView!!.displayTeamPlaying(game!!.getTeamPlaying())
    }

    private fun updateView() {
        gameView!!.displayAgentCards(game!!.cards)
        gameView!!.displayTeamScore(game!!.getBlueScore(), game!!.getRedScore())
        gameView!!.displayTeamPlaying(game!!.getTeamPlaying())
    }

    fun create(view: AgentViewContract, extras: Bundle?) {
        game = Game.Builder(gameRepository.getWords()).build()
        gameRepository.sendGameNotification(game!!)

        gameView = view
        updateView()
    }

    fun destroy() {
        game = null
        gameView = null
    }
}

