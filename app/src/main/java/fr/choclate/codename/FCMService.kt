package fr.choclate.codename

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import fr.choclate.codename.game.spymaster.SpyMasterActivity


class FCMService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.data.isNotEmpty()) {
            handle(remoteMessage.data)
        }
    }

    private fun handle(data: Map<String, String>) {
        val notification = NotificationCompat.Builder(applicationContext, "channelID")
            .setContentTitle("Hello")
            .setContentText("Want to play a game?")
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setContentIntent(getContentIntent(data))
        .build()

        val notificationManager = getSystemService(
            Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationId = 1
        notificationManager.notify(notificationId, notification)
    }

    private fun getContentIntent(data: Map<String, String>): PendingIntent {
        val intent = Intent(applicationContext, SpyMasterActivity::class.java)
        intent.putExtra("data", data.toString())

        return PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }
}
