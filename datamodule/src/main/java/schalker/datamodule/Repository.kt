package schalker.datamodule

import schalker.datamodule.remote.HotsService
import javax.inject.Inject

class Repository @Inject constructor() {
    @Inject lateinit var hotsService: HotsService

    fun getHeroes() = hotsService.getHeroes()
}