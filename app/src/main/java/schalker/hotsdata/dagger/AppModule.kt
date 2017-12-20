package schalker.hotsdata.dagger

import android.app.Application
import dagger.Module
import dagger.Provides
import schalker.datamodule.dagger.RemoteModule

@Module(includes = arrayOf(ViewModelModule::class, RemoteModule::class))
class AppModule(private val application: Application) {

    @Provides
    fun provideApplication() = application
}