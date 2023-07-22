package com.evirgenoguz.cocktailapp.presenter

import com.evirgenoguz.cocktailapp.data.ServerErrorModel

/**
 * @Author: Oguz Evirgen
 * @Date: 18.07.2023
 */

interface IndicatorPresenter {
    fun show()
    fun hide()
    fun showErrorDialog(serverError: ServerErrorModel)
    fun hideErrorDialog(serverError: ServerErrorModel)
}