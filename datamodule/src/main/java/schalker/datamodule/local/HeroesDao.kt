package schalker.datamodule.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import schalker.datamodule.models.Hero

@Dao
interface HeroesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(vararg heroes: Hero)

    @Query("SELECT * FROM hero")
    fun getAllHeroes(): LiveData<List<Hero>>
}