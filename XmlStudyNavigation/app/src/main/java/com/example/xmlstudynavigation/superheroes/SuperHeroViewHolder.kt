package com.example.xmlstudynavigation.superheroes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlstudynavigation.databinding.ItemSuperheroBinding
import com.example.xmlstudynavigation.model.SuperHeroesData

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superHeroItemResponse: SuperHeroesData) {
        binding.TextViewSuperHeroName.text = superHeroItemResponse.superHeroName
    }

}