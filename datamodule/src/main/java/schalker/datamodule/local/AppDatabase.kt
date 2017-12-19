package schalker.datamodule.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import schalker.datamodule.models.Hero

@Database(entities = arrayOf(Hero::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroesDao
}