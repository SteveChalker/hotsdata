package schalker.hotsdata.heroeslist

import android.app.Application
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import schalker.datamodule.models.Hero
import schalker.hotsdata.R
import javax.inject.Inject


class HeroListAdapter @Inject constructor() : RecyclerView.Adapter<HeroListAdapter.ViewHolder>() {
    private var heroList: List<Hero> = arrayListOf()
    @Inject lateinit var application: Application

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTextView.text = heroList[position].name

        Glide.with(application)
                .load(heroList[position].icon?.icon_url)
                .into(holder.iconImageView)
    }

    fun setHeroList(heroList: List<Hero>) {
        this.heroList = heroList
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView = view.findViewById(R.id.name) as TextView
        val iconImageView = view.findViewById(R.id.icon) as ImageView
    }
}