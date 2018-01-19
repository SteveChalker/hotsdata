package schalker.datamodule.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import schalker.datamodule.models.Ability
import schalker.datamodule.models.Hero
import schalker.datamodule.models.Talent

@Database(entities = arrayOf(Hero::class, Ability::class, Talent::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroesDao
    abstract fun talentDao(): TalentsDao
    abstract fun abilityDao(): AbilitiesDao
}