package com.evirgenoguz.cocktailapp.ui.feature.favorite

import android.view.LayoutInflater
import com.evirgenoguz.cocktailapp.core.BaseFragment
import com.evirgenoguz.cocktailapp.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentFavoriteBinding
        get() = FragmentFavoriteBinding::inflate

    override fun setupUi() {

    }


}