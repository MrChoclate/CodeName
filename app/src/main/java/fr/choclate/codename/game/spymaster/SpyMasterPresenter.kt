package fr.choclate.codename.game.spymaster

import android.os.Bundle
import com.google.gson.Gson
import fr.choclate.codename.game.CardModel
import fr.choclate.codename.game.Game
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SpyMasterPresenter @Inject constructor(private val gson: Gson){
    private var view: SpyMasterViewContract? = null

    fun create(view: SpyMasterViewContract, extras: Bundle?) {
        this.view = view

        val gameString = extras!!.getString("data")
        val game = gson.fromJson(gameString, Game::class.java)

        view.displaySpyMasterCards(game.cards.map {
            card -> CardModel(card.word, true, card.color) }
        )
    }

    fun destroy() {
        view = null
    }
}