package schalker.hotsdata.dagger

import android.content.Context
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(RemoteModule::class, ViewModelModule::class))
class AppModule(context: Context) {
    private val context = context.applicationContext

    @Provides
    fun provideContext() = context;
}