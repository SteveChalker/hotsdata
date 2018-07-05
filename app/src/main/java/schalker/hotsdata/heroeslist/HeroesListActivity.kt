package schalker.hotsdata.heroeslist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.opengl.Visibility
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.hero_list.*
import schalker.datamodule.models.Hero
import schalker.hotsdata.App
import schalker.hotsdata.R
import javax.inject.Inject

class HeroesListActivity : AppCompatActivity() {
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var heroListViewModel: HeroListViewModel
    private lateinit var viewManager: RecyclerView.LayoutManager
    @Inject lateinit var viewAdapter: HeroListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponenent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hero_list)

        heroListViewModel = ViewModelProviders.of(this, viewModelFactory).get(HeroListViewModel::class.java)

        heroListViewModel.heroes.observe(this, Observer<List<Hero>> { heroes ->
            //TODO clean up this logic
            if(heroes == null || heroes.isEmpty()) {
                hero_recycler_view.visibility = View.GONE
                no_heroes_found_tv.visibility = View.VISIBLE
            } else {
                no_heroes_found_tv.visibility = View.GONE
                hero_recycler_view.visibility = View.VISIBLE
                viewAdapter.setHeroList(heroes)
            }
        })

        fetch_heroes.setOnClickListener { heroListViewModel.fetchHeroes() }

        //TODO inject view manager
        viewManager = LinearLayoutManager(this)
        hero_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
