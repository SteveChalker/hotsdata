package schalker.datamodule.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "talent")
data class Talent(@PrimaryKey(autoGenerate = true) val id: Long,
                  val name: String,
                  val title: String,
                  val description: String,
                  var owner: String,
                  val ability: String,
                  val sort: Int,
                  val cooldown: Int,
                  @SerializedName("mana_cost") val manaCost: Int,
                  val level: Int) {
    @Ignore
    @SerializedName("icon_url")
    val icon: TalentIcon? = null
}