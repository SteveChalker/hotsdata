package schalker.hotsdata.dagger

import com.alexfacciorusso.daggerviewmodel.DaggerViewModelInjectionModule
import dagger.Component
import schalker.hotsdata.heroeslist.HeroesListActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DaggerViewModelInjectionModule::class))
interface AppComponent {
    fun inject(mainActivity: HeroesListActivity)
}