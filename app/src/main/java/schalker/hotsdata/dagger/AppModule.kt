package schalker.hotsdata.dagger

import android.content.Context
import dagger.Module

@Module(includes = arrayOf(RemoteModule::class))
class AppModule(context: Context) {
    val context = context.applicationContext
}