package schalker.hotsdata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import schalker.datamodule.Repository
import schalker.datamodule.models.Hero
import javax.inject.Inject

class HeroListViewModel @Inject constructor() : ViewModel() {
    @Inject lateinit var repository: Repository
    val heroes: MutableLiveData<List<Hero>> = MutableLiveData()

    fun fetchHeroes() = repository.getHeroes().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response -> heroes.value = response }
}