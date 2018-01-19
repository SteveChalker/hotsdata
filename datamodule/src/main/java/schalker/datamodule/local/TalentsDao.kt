package schalker.datamodule.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import schalker.datamodule.models.Talent

@Dao
interface TalentsDao {
    @Insert
    fun insertTalents(talents: List<Talent>)
}