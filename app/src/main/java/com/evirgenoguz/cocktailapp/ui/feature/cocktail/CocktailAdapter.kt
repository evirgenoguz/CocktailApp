package com.evirgenoguz.cocktailapp.ui.feature.cocktail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.evirgenoguz.cocktailapp.data.model.response.Cocktail
import com.evirgenoguz.cocktailapp.databinding.ItemCocktailBinding

/**
 * @Author: Oguz Evirgen
 * @Date: 4.07.2023
 */

class CocktailAdapter() : RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {



    var onItemClick: ((Cocktail) -> Unit)? = null
    private var cocktailList = listOf<Cocktail>()

    fun setCocktailList(cocktailList: List<Cocktail>?){
        this.cocktailList = cocktailList ?: emptyList()
        notifyDataSetChanged()
    }

    inner class CocktailViewHolder(
        private val binding: ItemCocktailBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cocktail: Cocktail) {
            Glide.with(binding.root.context)
                .load(cocktail.strDrinkThumb)
                .into(binding.ivCocktailImage)

            binding.tvCocktailName.text = cocktail.strDrink

            itemView.setOnClickListener {
                onItemClick!!.invoke(cocktail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        return CocktailViewHolder(
            ItemCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = cocktailList.size


    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        val cocktail = cocktailList[position]

        holder.bind(cocktail)
    }

}