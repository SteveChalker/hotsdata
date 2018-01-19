package schalker.datamodule.local

import android.arch.persistence.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: String): Date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(value)
}