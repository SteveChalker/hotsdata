package schalker.datamodule.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import schalker.datamodule.models.Ability

@Dao
interface AbilitiesDao {
    @Insert
    fun insertAbilities(abilities: List<Ability>)
}