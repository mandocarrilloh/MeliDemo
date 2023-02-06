package com.mandocarrilloh.melidemo.ui.base

import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.annotation.CallSuper
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.mandocarrilloh.melidemo.R
import com.mandocarrilloh.melidemo.ui.flow.views.Loading

enum class TypesSnackBar {
    ERROR,
    SUCCESS,
    HELP,
    WARNING,
}

abstract class BaseFragment : Fragment() {

    private var loadingBar: Loading? = null

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected fun subscribeViewModel(viewModel: BaseViewModel, view: View) {
        viewModel.loader.observe(viewLifecycleOwner, Observer(::showLoading))
    }

    /**
     * Loading
     */

    private fun initLoading() {
        removeLoading()
        if (loadingBar == null) {
            loadingBar = Loading(requireContext())
            activity?.addContentView(
                loadingBar,
                LayoutParams(MATCH_PARENT, MATCH_PARENT)
            )
        }
    }

    protected open fun showLoading(showing: Boolean) {
        initLoading()
        loadingBar?.setState(showing)
    }

    private fun removeLoading() {
        if (loadingBar != null) {
            val viewParent = loadingBar?.parent
            if (viewParent != null && viewParent is ViewManager) {
                (viewParent as ViewManager).removeView(loadingBar)
            }
        }
        loadingBar = null
    }

    /**
     * Actions
     */

    protected fun setStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity?.let {
                val window: Window = it.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = ContextCompat.getColor(requireContext(), color)
            }
        }
    }

    /**
     * SnackBar
     */

    protected fun showSnackBar(
        view: View,
        message: String,
        type: TypesSnackBar = TypesSnackBar.SUCCESS
    ) {
        val snackBar = getSnackBar(view, message)
        colorSnackBar(snackBar,type).show()
    }

    private fun getSnackBar(view: View, message: String) =
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)

    private fun colorSnackBar(snackbar: Snackbar, type: TypesSnackBar): Snackbar {
        val snackBarView = snackbar.view
        val colorId = when (type) {
            TypesSnackBar.SUCCESS -> ContextCompat.getColor(requireContext(), R.color.colorGreen)
            TypesSnackBar.ERROR -> ContextCompat.getColor(requireContext(), R.color.colorRed)
            TypesSnackBar.WARNING -> ContextCompat.getColor(requireContext(), R.color.colorPrimary)
            TypesSnackBar.HELP -> ContextCompat.getColor(requireContext(), R.color.colorBlue)
        }
        snackBarView.setBackgroundColor(colorId)
        return snackbar
    }

}