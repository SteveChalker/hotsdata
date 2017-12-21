package schalker.datamodule.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "hero")
data class Hero(@PrimaryKey val name: String,
                @SerializedName("short_name")val shortName: String,
                val role: String)