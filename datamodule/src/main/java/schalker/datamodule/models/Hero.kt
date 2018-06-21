package schalker.datamodule.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "hero")
data class Hero(@PrimaryKey var name: String = "",
                @SerializedName("short_name")var shortName: String = "",
                @SerializedName("attribute_id")var attributeId: String = "",
                var role: String = "",
                var type: String = "",
                @SerializedName("release_date")var releaseDate: String = ""
                ) {

    //Room/kotlin does not like the ignore annotation in the constructor need to figure out why
    @Ignore
    @SerializedName("icon_url")
    val icon: HeroIcon? = null

    @Ignore
    val abilities: List<Ability> = emptyList()

    @Ignore
    val talents: List<Talent> = emptyList()
}