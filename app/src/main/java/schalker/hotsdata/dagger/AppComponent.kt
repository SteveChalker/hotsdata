package schalker.hotsdata.dagger

import com.alexfacciorusso.daggerviewmodel.DaggerViewModelInjectionModule
import dagger.Component
import schalker.hotsdata.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DaggerViewModelInjectionModule::class))
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}