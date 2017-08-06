package fr.choclate.codename.game

import android.content.Context
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.choclate.codename.R
import shuffle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(val context: Context, val gameService: GameService) {
    fun sendGameNotification(game: Game) {
        //TODO: we send notification to every one, we should select only some users
        FirebaseDatabase.getInstance().getReference("users")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(dataSnapshot: DataSnapshot?) {
                    dataSnapshot?.children?.forEach {
                        data -> val to = data?.value.toString()
                        gameService.sendGame(FCMGameData(to, game)).subscribe()
                    }
                }
            })
    }

    fun getWords(): List<String> {
        val words = context.resources.getStringArray(R.array.words)
        return words.toList().shuffle().subList(0, Game.CARDS_NUMBER)
    }
}