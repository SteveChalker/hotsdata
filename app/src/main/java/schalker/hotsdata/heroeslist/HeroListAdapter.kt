package schalker.hotsdata.heroeslist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import schalker.datamodule.models.Hero
import schalker.hotsdata.R

class HeroListAdapter(private var heroList: List<Hero>) : RecyclerView.Adapter<HeroListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTextView.text = heroList[position].name
    }

    fun setHeroList(heroList: List<Hero>) {
        this.heroList = heroList
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView = view.findViewById(R.id.name) as TextView
    }
}