package com.evirgenoguz.cocktailapp.ui.feature.cocktail


import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.evirgenoguz.cocktailapp.core.BaseFragment
import com.evirgenoguz.cocktailapp.databinding.FragmentCocktailBinding
import com.evirgenoguz.cocktailapp.ext.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailFragment : BaseFragment<FragmentCocktailBinding>() {

    override val bindingInflater: (inflater: LayoutInflater) -> FragmentCocktailBinding
        get() = FragmentCocktailBinding::inflate

    private val viewModel by viewModels<CocktailViewModel>()

    private lateinit var cocktailAdapter: CocktailAdapter


    override fun setupUi() {
        initListeners()
        prepareAdapter()
        observeCocktailLiveData()
        onCocktailClick()
        onFavoriteClick()
    }



    private fun prepareAdapter() {
        cocktailAdapter = CocktailAdapter()
        binding.rvCocktails.apply {
            adapter = cocktailAdapter
        }
    }

    private fun observeCocktailLiveData() {
        viewModel.cocktails.observe(viewLifecycleOwner) { result ->
            result.onLoading {
                // TODO Create a loading animation for here
                toast("Loading animation")
            }.onSuccess { cocktailList ->
                cocktailAdapter.setCocktailList(cocktailList.cocktailList)
            }.onError { error ->
                // TODO create a dialog fragment for showing error messages
                toast(error.message)
            }
        }

    }

    private fun initListeners() {

    }

    private fun onCocktailClick() {
        cocktailAdapter.onItemClick = { cocktail ->
            Log.d("CocktailAdapter", cocktail.idDrink)
            findNavController().navigate(CocktailFragmentDirections.actionCocktailFragmentToCocktailDetailFragment(cocktail.idDrink))
        }
    }

    private fun onFavoriteClick() {
        cocktailAdapter.onFavoriteClick = { cocktail ->
            Log.d("CocktailAdapter", cocktail.idDrink)
            //viewModel.upsertCocktail(cocktail)
        }
    }



}