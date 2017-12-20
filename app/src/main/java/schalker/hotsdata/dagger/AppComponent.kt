package schalker.hotsdata.dagger

import com.alexfacciorusso.daggerviewmodel.DaggerViewModelInjectionModule
import dagger.Component
import schalker.datamodule.dagger.LocalModule
import schalker.datamodule.dagger.RemoteModule
import schalker.hotsdata.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, RemoteModule::class, LocalModule::class, ViewModelModule::class, DaggerViewModelInjectionModule::class))
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}