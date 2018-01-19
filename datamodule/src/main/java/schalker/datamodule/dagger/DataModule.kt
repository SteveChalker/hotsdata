package schalker.datamodule.dagger

import android.app.Application
import android.arch.persistence.room.Room
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import schalker.datamodule.local.AppDatabase
import schalker.datamodule.remote.HotsService
import javax.inject.Singleton

@Module
class DataModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Provides
    @Singleton
    fun providesOkhttpClient(): OkHttpClient = okhttp3.OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

    @Provides
    @Singleton
    fun providesHotsService(retrofit: Retrofit): HotsService = retrofit.create(HotsService::class.java)

    @Singleton
    @Provides
    fun providesAppDatabase(application: Application) = Room.databaseBuilder(application, AppDatabase::class.java, "app-db").build()

    @Singleton
    @Provides
    fun providesHeroesDao(appDatabase: AppDatabase) = appDatabase.heroDao()

    @Singleton
    @Provides
    fun providesAbilitiesDao(appDatabase: AppDatabase) = appDatabase.abilityDao()

    @Singleton
    @Provides
    fun providesTalentsDao(appDatabase: AppDatabase) = appDatabase.talentDao()
}