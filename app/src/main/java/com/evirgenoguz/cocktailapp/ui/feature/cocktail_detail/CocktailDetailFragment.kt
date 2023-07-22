package com.evirgenoguz.cocktailapp.ui.feature.cocktail_detail

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.evirgenoguz.cocktailapp.core.BaseFragment
import com.evirgenoguz.cocktailapp.databinding.FragmentCocktailDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailDetailFragment : BaseFragment<FragmentCocktailDetailBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentCocktailDetailBinding
        get() = FragmentCocktailDetailBinding::inflate

    override val viewModel by viewModels<CocktailDetailViewModel>()

    private val args: CocktailDetailFragmentArgs by navArgs()

    override fun setupUi() {
        observeCocktailLiveData()

        val cocktailId: String = args.cocktailId
        viewModel.getCocktailDetailById(cocktailId)
    }

    private fun observeCocktailLiveData() {
        viewModel.cocktailDetail.observe(viewLifecycleOwner) { result ->
            result.onSuccess { cocktailList ->
                Glide.with(binding.root.context)
                    .load(cocktailList.cocktailDetailList?.get(0)?.strDrinkThumb)
                    .into(binding.imageViewCocktailImage)

                binding.textViewCocktailName.text = cocktailList.cocktailDetailList?.get(0)?.strDrink ?: ""
                binding.textViewInstructions.text = cocktailList.cocktailDetailList?.get(0)?.strInstructions ?: ""
            }
        }

    }




}