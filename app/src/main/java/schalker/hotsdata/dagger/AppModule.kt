package schalker.hotsdata.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import schalker.datamodule.dagger.LocalModule
import schalker.datamodule.dagger.RemoteModule

@Module
class AppModule(context: Context) {
    private val context = context.applicationContext

    @Provides
    fun provideContext() = context
}