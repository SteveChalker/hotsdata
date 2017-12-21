package schalker.hotsdata

import android.app.Application
import com.facebook.stetho.Stetho
import schalker.datamodule.dagger.DataModule
import schalker.hotsdata.dagger.AppComponent
import schalker.hotsdata.dagger.AppModule
import schalker.hotsdata.dagger.DaggerAppComponent

class App : Application() {
    val appComponenent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .dataModule(DataModule("https://hotsapi.net/api/v1/"))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}