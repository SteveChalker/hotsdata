package schalker.datamodule.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import schalker.datamodule.models.Talent

@Dao
interface TalentsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTalents(talents: List<Talent>)
}