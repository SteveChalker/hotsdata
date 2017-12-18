package schalker.hotsdata

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    @Inject lateinit var viewModelFactory:ViewModelProvider.Factory

    lateinit var heroListViewModel: HeroListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponenent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heroListViewModel = ViewModelProviders.of(this, viewModelFactory).get(HeroListViewModel::class.java)

        fetch_heroes.setOnClickListener {
            heroListViewModel.getHeroes()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe{response -> heroes_list_text_view.text = response[0].name}
        }
    }
}
