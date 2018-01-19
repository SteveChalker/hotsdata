package schalker.datamodule

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import schalker.datamodule.local.AbilitiesDao
import schalker.datamodule.local.HeroesDao
import schalker.datamodule.local.TalentsDao
import schalker.datamodule.remote.HotsService
import java.util.*
import javax.inject.Inject

class Repository @Inject constructor(var hotsService: HotsService,
                                     var heroesDao: HeroesDao,
                                     var talentsDao: TalentsDao,
                                     var abilitiesDao: AbilitiesDao) {

    fun getHeroes() = heroesDao.getAllHeroes()

    fun refreshData() = hotsService.getHeroes().subscribeOn(Schedulers.io())
            .subscribe { response ->
                heroesDao.insertHeroes(response)
                response.forEach { hero ->
                    abilitiesDao.insertAbilities(hero.abilities)
                    hero.talents.forEach { it.owner = hero.shortName }
                    talentsDao.insertTalents(hero.talents)
                }
            }
}