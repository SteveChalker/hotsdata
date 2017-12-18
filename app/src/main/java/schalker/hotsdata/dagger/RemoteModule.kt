package schalker.hotsdata.dagger

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import schalker.datamodule.remote.HotsService
import javax.inject.Singleton

@Module
class RemoteModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providesHotsService(retrofit: Retrofit): HotsService = retrofit.create(HotsService::class.java)
}