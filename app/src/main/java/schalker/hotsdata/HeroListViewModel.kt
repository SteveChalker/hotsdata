package schalker.hotsdata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import schalker.datamodule.Repository
import schalker.datamodule.models.Hero
import javax.inject.Inject

class HeroListViewModel @Inject constructor(val repository: Repository) : ViewModel() {
    val heroes: LiveData<List<Hero>> = repository.getHeroes()

    fun fetchHeroes() {
        repository.refreshData()
    }
}