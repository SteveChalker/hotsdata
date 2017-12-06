package schalker.hotsdata.dagger

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import schalker.datamodule.remote.HotsService
import javax.inject.Singleton

@Module
class RemoteModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit = Retrofit.Builder().baseUrl(baseUrl).build()

    @Provides
    fun providesHotsService(retrofit: Retrofit): HotsService = retrofit.create(HotsService::class.java)
}