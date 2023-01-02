package com.arhelicortes.catfact_dagger.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arhelicortes.catfact_dagger.R
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto

class CatBreedsCustomAdapter(
    private val catBreads: List<CatBreedDataDto>,
    private val clickListener: (CatBreedDataDto) -> Unit,
): RecyclerView.Adapter<CatBreedsCustomAdapter.ViewHolder>() {

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(catBreed: CatBreedDataDto, clickListener: (CatBreedDataDto) -> Unit) {
            val catBreedName= view.findViewById<TextView>(R.id.catBreedNameTextView)
            catBreedName.text = catBreed.breed
            view.setOnClickListener {
                clickListener(catBreed)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cat_breed_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(catBreads[position], clickListener)
    }

    override fun getItemCount(): Int = catBreads.size
}