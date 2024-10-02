package com.example.middlexmlhoroscopo.ui.horoscopo.adapter

import android.content.Context
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.middlexmlhoroscopo.databinding.ItemHoroscopoBinding
import com.example.middlexmlhoroscopo.domain.model.HoroscopoInfo

class HoroscopoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(horoscopoInfo: HoroscopoInfo, onItemSelected: (HoroscopoInfo) -> Unit) {
        val context: Context = binding.root.context
        binding.ImageViewHoroscopo.setImageResource(horoscopoInfo.img)
        binding.TextViewHoroscopo.text = context.getString(horoscopoInfo.name)
        binding.Parent.setOnClickListener {
            startRotation(binding.ImageViewHoroscopo, newLambda = { onItemSelected(horoscopoInfo) })
            /*onItemSelected(horoscopoInfo)*/
        }
    }

    private fun startRotation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLambda() }
            start()
        }
    }
}

