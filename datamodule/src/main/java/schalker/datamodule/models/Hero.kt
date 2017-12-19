package schalker.datamodule.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "hero")
data class Hero(@PrimaryKey val name: String,
                val shortName: String,
                val role: String)