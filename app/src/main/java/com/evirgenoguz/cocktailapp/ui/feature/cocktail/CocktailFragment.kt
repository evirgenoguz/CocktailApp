package com.evirgenoguz.cocktailapp.ui.feature.cocktail


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.evirgenoguz.cocktailapp.R
import com.evirgenoguz.cocktailapp.core.BaseFragment
import com.evirgenoguz.cocktailapp.databinding.FragmentCocktailBinding
import com.evirgenoguz.cocktailapp.ext.toast
import com.google.android.material.snackbar.Snackbar
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
        onCategoryClick()
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

    private fun onCategoryClick() {
        cocktailAdapter.onItemClick = { cocktail ->
            Log.d("CocktailAdapter", cocktail.idDrink)
            findNavController().navigate(CocktailFragmentDirections.actionCocktailFragmentToCocktailDetailFragment(cocktail.idDrink))
        }
    }

}