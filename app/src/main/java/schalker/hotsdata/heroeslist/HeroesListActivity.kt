package schalker.hotsdata.heroeslist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import schalker.datamodule.models.Hero
import schalker.hotsdata.App
import schalker.hotsdata.R
import javax.inject.Inject

class HeroesListActivity : AppCompatActivity() {
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var heroListViewModel: HeroListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponenent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heroListViewModel = ViewModelProviders.of(this, viewModelFactory).get(HeroListViewModel::class.java)

        heroListViewModel.heroes.observe(this, Observer<List<Hero>> { heroes ->
            heroes_list_text_view.text = heroes?.let {
                if (it.isEmpty()) "Heroes not found" else it.joinToString(",", transform = {hero ->  hero.name})
            }
        })

        fetch_heroes.setOnClickListener { heroListViewModel.fetchHeroes() }
    }
}
