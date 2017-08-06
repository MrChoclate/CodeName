package fr.choclate.codename.di


import dagger.Component
import fr.choclate.codename.game.agent.AgentActivity
import fr.choclate.codename.game.spymaster.SpyMasterActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetModule::class, ServiceModule::class))
interface DefaultComponent {
    fun inject(agentActivity: AgentActivity)
    fun inject(spyMasterActivity: SpyMasterActivity)
}