package com.arhelicortes.catfact_dagger.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arhelicortes.catfact_dagger.R
import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDataDto

class CatFactCustomAdapter(
    private val catFacts: List<CatFactDataDto>,
    private val clickListener: (CatFactDataDto) -> Unit,
): RecyclerView.Adapter<CatFactCustomAdapter.ViewHolder>() {

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind (catFacts: CatFactDataDto, clickListener: (CatFactDataDto) -> Unit) {
            val catFactText= view.findViewById<TextView>(R.id.catFactTextView)
            catFactText.text = catFacts.fact
            view.setOnClickListener {
                clickListener(catFacts)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cat_fact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(catFacts[position], clickListener)
    }

    override fun getItemCount(): Int = catFacts.size


}