package schalker.datamodule.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import schalker.datamodule.models.Ability

@Dao
interface AbilitiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAbilities(abilities: List<Ability>)
}