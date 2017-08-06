package fr.choclate.codename.game.agent

import fr.choclate.codename.game.CardModel
import fr.choclate.codename.game.Team


interface AgentViewContract {
    fun displayTeamScore(blueScore: Int, redScore: Int)
    fun displayAgentCards(cards: List<CardModel>)
    fun displayTeamPlaying(teamPlaying: Team?)
}