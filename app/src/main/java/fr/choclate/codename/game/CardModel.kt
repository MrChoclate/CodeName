package fr.choclate.codename.game

enum class Team {
    RED, BLUE, KILLER, NEUTRAL
}

data class CardModel(val word: String, val isFound: Boolean, val color: Team)