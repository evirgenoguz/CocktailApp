package com.evirgenoguz.cocktailapp.presenter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.evirgenoguz.cocktailapp.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class NoInternetDialogPresenterImpl(
    private val context: Context
) : NoInternetDialogPresenter {

    private var noInternetDialog: androidx.appcompat.app.AlertDialog? = null

    init {
        initNoInternetDialog()
    }

    override fun show() {
        if (noInternetDialog == null || isActivityRunning().not()) return

        noInternetDialog?.let {
            if (it.isShowing.not()) {
                it.show()
            }
        }
    }

    override fun hide() {
        if (noInternetDialog == null || isActivityRunning().not()) return

        noInternetDialog?.let {
            if (it.isShowing) {
                it.dismiss()
            }
        }
    }

    private fun isActivityRunning(): Boolean =
        (context as AppCompatActivity).lifecycle.currentState != Lifecycle.State.DESTROYED

    private fun initNoInternetDialog() {
        val builder = MaterialAlertDialogBuilder(context, R.style.StyleNoInternetDialog)
        builder.setCancelable(false)
        builder.setView(R.layout.dialog_no_internet)
        noInternetDialog = builder.create()
        (context as AppCompatActivity).lifecycle.addObserver(
            DialogDismissLifecycleObserver(
                noInternetDialog
            )
        )
    }

    class DialogDismissLifecycleObserver(
        private var dialog: AppCompatDialog?
    ) : LifecycleEventObserver {
        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                dialog?.dismiss()
                dialog = null
            }
        }
    }
}