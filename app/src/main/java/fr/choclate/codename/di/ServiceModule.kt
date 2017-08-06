package fr.choclate.codename.di

import dagger.Module
import dagger.Provides
import fr.choclate.codename.game.GameService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideGameService(retrofit: Retrofit): GameService {
        return retrofit.create(GameService::class.java)
    }
}