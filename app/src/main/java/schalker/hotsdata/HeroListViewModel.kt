package schalker.hotsdata

import android.arch.lifecycle.ViewModel
import schalker.datamodule.remote.HotsService
import javax.inject.Inject

class HeroListViewModel @Inject constructor(): ViewModel() {
    @Inject lateinit var hotsService: HotsService

    fun getHeroes() = hotsService.getHeroes()
}