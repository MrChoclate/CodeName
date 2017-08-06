package fr.choclate.codename

import android.support.v7.app.AppCompatActivity
import fr.choclate.codename.di.DefaultComponent


abstract class BaseActivity: AppCompatActivity() {
    protected fun getMyApplication(): MyApplication {
        return application as MyApplication
    }

    protected fun getDefaultComponent(): DefaultComponent {
        return getMyApplication().getComponent()
    }
}
