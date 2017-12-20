package schalker.datamodule.dagger

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import schalker.datamodule.local.AppDatabase
import javax.inject.Singleton

@Module
class LocalModule constructor(context: Context){
    private val appDatabase: AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "app-db").build()

    @Singleton
    @Provides
    fun providesAppDatabase() = appDatabase

    @Singleton
    @Provides
    fun providesHeroesDao(appDatabase: AppDatabase) = appDatabase.heroDao()
}