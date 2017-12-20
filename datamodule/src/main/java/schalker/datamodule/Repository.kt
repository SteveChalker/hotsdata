package schalker.datamodule

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import schalker.datamodule.local.HeroesDao
import schalker.datamodule.remote.HotsService
import javax.inject.Inject

class Repository @Inject constructor(var hotsService: HotsService, var heroesDao: HeroesDao) {

    fun getHeroes() = heroesDao.getAllHeroes()

    fun refreshData() = hotsService.getHeroes().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{response -> heroesDao.insertHeroes(response)}
}