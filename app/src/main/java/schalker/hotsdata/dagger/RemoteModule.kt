package schalker.hotsdata.dagger

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import schalker.datamodule.remote.HotsService
import javax.inject.Singleton

@Module
class RemoteModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Provides
    fun providesOkhttpClient(): OkHttpClient = okhttp3.OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

    @Provides
    fun providesHotsService(retrofit: Retrofit): HotsService = retrofit.create(HotsService::class.java)
}