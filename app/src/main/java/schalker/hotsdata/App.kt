package schalker.hotsdata

import android.app.Application
import schalker.hotsdata.dagger.AppComponent
import schalker.hotsdata.dagger.AppModule
import schalker.hotsdata.dagger.DaggerAppComponent

class App : Application() {

    val appComponenent: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build() }
}