package fr.choclate.codename.game.spymaster

import fr.choclate.codename.game.CardModel

interface SpyMasterViewContract {
    fun displaySpyMasterCards(cards: List<CardModel>)
}