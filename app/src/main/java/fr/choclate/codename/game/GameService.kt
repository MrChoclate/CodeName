package fr.choclate.codename.game

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST


data class FCMGameData(val to: String, val data: Game)
data class Result(val messageId: String)
data class FCMResponse(
    val multicastId: Int,
    val success: Int,
    val failure: Int,
    val canonicalId: Int,
    val results: List<Result>
)

interface GameService {
    @POST("fcm/send") fun sendGame(@Body fcmGameData: FCMGameData): Observable<FCMResponse>
}