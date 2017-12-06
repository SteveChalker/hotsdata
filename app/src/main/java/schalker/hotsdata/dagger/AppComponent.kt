package schalker.hotsdata.dagger

import dagger.Component
import schalker.hotsdata.MainActivity

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}