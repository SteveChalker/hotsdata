package schalker.datamodule.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import schalker.datamodule.models.Hero

@Database(entities = arrayOf(Hero::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroesDao
}