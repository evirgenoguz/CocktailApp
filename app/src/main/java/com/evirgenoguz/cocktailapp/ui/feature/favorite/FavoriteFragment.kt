package com.evirgenoguz.cocktailapp.ui.feature.favorite

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import com.evirgenoguz.cocktailapp.core.BaseFragment
import com.evirgenoguz.cocktailapp.core.BaseViewModel
import com.evirgenoguz.cocktailapp.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentFavoriteBinding
        get() = FragmentFavoriteBinding::inflate

    override val viewModel: FavoriteViewModel by viewModels()

    override fun setupUi() {

    }


}