package schalker.datamodule.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ability")
data class Ability(val id: Long,
                   val owner: String,
                   val name: String,
                   @PrimaryKey val title: String,
                   val description: String,
                   val hotkey: String?,
                   val cooldown: Int,
                   @SerializedName("mana_cost") val manaCost: Int,
                   val trait: Boolean
)