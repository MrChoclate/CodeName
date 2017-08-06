package fr.choclate.codename.game

import shuffle
import java.io.Serializable
import java.util.*

class Game constructor(
    val cards: MutableList<CardModel>, private var teamPlaying: Team?
): Serializable {
    companion object {
        val CARDS_NUMBER: Int = 25
    }

    class Builder(val words: List<String>) {
        private var  cards: MutableList<CardModel>? = null
        private var team: Team? = null

        fun setAgentCards(cards: MutableList<CardModel>): Builder {
            this.cards = cards
            return this
        }

        fun setFirstTeam(team: Team): Builder {
            this.team = team
            return this
        }

        fun build(): Game {
            if (team == null) {
                team = if (Random().nextBoolean()) Team.RED else Team.BLUE
            }
            if (cards == null) {
                cards = generateNewRandomCards()
            }

            return Game(cards!!, team!!)
        }

        private fun generateNewRandomCards(): MutableList<CardModel> {
            return MutableList(Companion.CARDS_NUMBER, { index ->
                val team: Team = pickTeam(index)
                val word = words[index]

                CardModel(word, false, team)
            }).shuffle()
        }

        private fun pickTeam(index: Int): Team {
            val isRedStarting = team == Team.RED

            val team: Team
            if (index < 8) {
                team = Team.BLUE
            } else if (index < 16) {
                team = Team.RED
            } else if (index == 16) {
                team = if (isRedStarting) Team.RED else Team.BLUE
            } else if (index == 17) {
                team = Team.KILLER
            } else {
                team = Team.NEUTRAL
            }

            return team
        }
    }

    fun play(cardToBePlayed: CardModel) {
        val index = cards.indexOfFirst { c -> c.word == cardToBePlayed.word }
        var card = cards[index]

        if (card.isFound) {
            return
        }
        if (card.color != teamPlaying) {
            skipTeamTurn()
        }

        if (card.color == Team.KILLER) {
            killerFound()
        }

        card = CardModel(card.word, true, card.color)
        cards[index] = card
    }

    fun getRedScore(): Int {
        return teamScore(Team.RED)
    }

    fun getBlueScore(): Int {
        return teamScore(Team.BLUE)
    }

    fun getTeamPlaying(): Team? {
        return teamPlaying
    }

    fun skipTeamTurn() {
        if (teamPlaying == Team.RED) {
            teamPlaying = Team.BLUE
        } else {
            teamPlaying = Team.RED
        }
    }

    private fun teamScore(team: Team): Int {
        return cards.filter { c -> c.color == team && !c.isFound }.size
    }

    private fun killerFound() {
        cards.forEachIndexed { index, c -> cards[index] = CardModel(c.word, true, c.color) }
        teamPlaying = null
    }
}