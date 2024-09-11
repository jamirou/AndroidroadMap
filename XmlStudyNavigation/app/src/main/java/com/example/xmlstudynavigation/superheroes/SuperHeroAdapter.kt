package com.example.xmlstudynavigation.superheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.model.SuperHeroesData

class SuperHeroAdapter(
    var superHeroList: List<SuperHeroesData> = emptyList()
) : RecyclerView.Adapter<SuperHeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        return SuperHeroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(superHeroList[position])
    }

    override fun getItemCount() = superHeroList.size
}