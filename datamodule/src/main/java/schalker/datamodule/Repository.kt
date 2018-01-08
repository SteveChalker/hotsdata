package schalker.datamodule

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import schalker.datamodule.local.HeroesDao
import schalker.datamodule.remote.HotsService
import java.util.*
import javax.inject.Inject

class Repository @Inject constructor(var hotsService: HotsService, var heroesDao: HeroesDao) {

    fun getHeroes() = heroesDao.getAllHeroes()

    fun refreshData() = hotsService.getHeroes().subscribeOn(Schedulers.io())
            .subscribe{response -> heroesDao.insertHeroes(response)}
    //Add ignored fieled to entity for list of abilities and talents
    //create entities for abilities and talents
    //on respoonse insert abilities
    //on response add owner name to talents object and then insert

}