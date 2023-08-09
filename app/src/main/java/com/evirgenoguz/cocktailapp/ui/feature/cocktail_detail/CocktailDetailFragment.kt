package com.evirgenoguz.cocktailapp.ui.feature.cocktail_detail

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.evirgenoguz.cocktailapp.core.BaseFragment
import com.evirgenoguz.cocktailapp.databinding.FragmentCocktailDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

@AndroidEntryPoint
class CocktailDetailFragment : BaseFragment<FragmentCocktailDetailBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentCocktailDetailBinding
        get() = FragmentCocktailDetailBinding::inflate

    override val viewModel by viewModels<CocktailDetailViewModel>()

    private val args: CocktailDetailFragmentArgs by navArgs()

    override fun setupUi() {
        observeCocktailLiveData()

        viewModel.getCocktailDetailById(args.cocktailId)

        if (viewModel.cocktailDetail.value?.strVideo == null){
            binding.imageViewYoutube.visibility = View.GONE
        }

        initListeners()
    }

    private fun initListeners() {
        binding.imageViewYoutube.setOnClickListener {
            //send to the youtube with using intent but you need a link that come from viewmodel
            val videoSrc = viewModel.cocktailDetail.value?.strVideo ?: return@setOnClickListener
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoSrc))
            startActivity(intent)
        }
    }

    private fun observeCocktailLiveData() {
        viewModel.cocktailDetail.observe(viewLifecycleOwner) { cocktailDetailUiModel ->

            Glide.with(binding.root.context)
                .load(cocktailDetailUiModel.strDrinkThumb)
                .into(binding.imageViewCocktailImage)

            binding.textViewCocktailName.text = cocktailDetailUiModel.strDrink
            binding.textViewInstructions.text = cocktailDetailUiModel.strInstructions
            binding.textViewCategory.text = cocktailDetailUiModel.strCategory
            binding.textViewGlass.text = cocktailDetailUiModel.strGlass

            val stringBuilder = StringBuilder("Ingredients: \n")

            cocktailDetailUiModel.strMeasureList.forEachIndexed { index, s ->
                stringBuilder.append("$s ${cocktailDetailUiModel.strIngredientList[index]} ")
            }

            binding.textViewIngredientList.text = stringBuilder
        }
    }
}
