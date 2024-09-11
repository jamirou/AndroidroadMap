package com.example.xmlstudynavigation.superheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.model.SuperHeroesData

class SuperHeroAdapter(
    var superHeroList: List<SuperHeroesData> = emptyList(),
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<SuperHeroViewHolder>() {

    fun updateSuperHeroList(superHeroList: List<SuperHeroesData>) {
        this.superHeroList = superHeroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        return SuperHeroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(superHeroList[position], onItemSelected)
    }

    override fun getItemCount() = superHeroList.size
}