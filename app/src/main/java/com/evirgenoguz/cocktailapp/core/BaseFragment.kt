package com.evirgenoguz.cocktailapp.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.evirgenoguz.cocktailapp.presenter.IndicatorPresenter
import com.evirgenoguz.cocktailapp.presenter.NoInternetDialogPresenter
import com.evirgenoguz.cocktailapp.utils.NetworkLiveData
import javax.inject.Inject

/**
 * @Author: OguzEvirgen
 * @Date: 2.07.2023
 */

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding!!

    // The TAG value to use in logs.
    @Suppress("PropertyName")
    protected val TAG: String = javaClass.simpleName

    // The inflater class for ViewBinding
    abstract val bindingInflater: (LayoutInflater) -> VB

    @Inject
    lateinit var indicatorPresenter: IndicatorPresenter

    @Inject
    lateinit var noInternetDialog: NoInternetDialogPresenter

    protected abstract val viewModel: BaseViewModel

    // The function to handle ui setup
    abstract fun setupUi()

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(layoutInflater)
        return binding.root

    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectViewModel(viewModel)
        setupUi()
    }

    /**
     * @param initialRequests makes requests to be made when there is an internet connection.
     * if the user don't have an internet connection the dialog pop-up and warn the user.
     */
    open fun checkNetworkStateAndRequest(initialRequests: () -> Unit) {
        NetworkLiveData(requireContext()).observe(viewLifecycleOwner) {
            if (it){
                noInternetDialog.hide()
                initialRequests.invoke()
            } else {
                noInternetDialog.show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    open fun <VM : BaseViewModel> connectViewModel(vararg viewModels: VM) {
        viewModels.forEach { viewModel ->
            viewModel.indicator.observe(viewLifecycleOwner) { isLoading ->
                if (isLoading) {
                    indicatorPresenter.show()
                } else {
                    indicatorPresenter.hide()
                }
            }
        }
    }
}