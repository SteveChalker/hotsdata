package schalker.hotsdata.dagger

import android.arch.lifecycle.ViewModel
import com.alexfacciorusso.daggerviewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import schalker.hotsdata.HeroListViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HeroListViewModel::class)
    abstract fun bindsHeroListViewModel(heroListViewModel: HeroListViewModel): ViewModel
}