package schalker.datamodule

import schalker.datamodule.local.HeroesDao
import schalker.datamodule.remote.HotsService
import javax.inject.Inject

class Repository @Inject constructor() {
    @Inject lateinit var hotsService: HotsService
    @Inject lateinit var heroesDao: HeroesDao

    fun getHeroes() = hotsService.getHeroes()

    fun refreshData() =
}