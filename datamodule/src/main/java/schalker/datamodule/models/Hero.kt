package schalker.datamodule.models

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "hero")
data class Hero(@PrimaryKey val name: String,
                @SerializedName("short_name")val shortName: String,
                @SerializedName("attribute_id")val attributeId: String,
                val role: String,
                val type: String,
                @SerializedName("release_date")val releaseDate: String,
                @Embedded @SerializedName("icon_url") val icon: HeroIcon? = null) {

    //Room/kotlin does not like the ignore annotation in the constructor need to figure out why
    @Ignore
    val abilities: List<Ability> = emptyList()

    @Ignore
    val talents: List<Talent> = emptyList()
}