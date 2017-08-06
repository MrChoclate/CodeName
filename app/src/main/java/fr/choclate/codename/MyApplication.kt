package fr.choclate.codename


import android.app.Application
import fr.choclate.codename.di.ApplicationModule
import fr.choclate.codename.di.DaggerDefaultComponent
import fr.choclate.codename.di.DefaultComponent
import fr.choclate.codename.di.NetModule


class MyApplication: Application() {
    private lateinit var mComponent: DefaultComponent

    override fun onCreate() {
        super.onCreate()
        mComponent = DaggerDefaultComponent.builder()
            .netModule(NetModule())
            .applicationModule(ApplicationModule(this))
            .build()
    }

    fun getComponent(): DefaultComponent {
        return mComponent
    }
}