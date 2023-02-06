package com.mandocarrilloh.melidemo.ui.flow.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mandocarrilloh.melidemo.R
import com.mandocarrilloh.melidemo.databinding.ActivityHomeBinding
import com.mandocarrilloh.melidemo.ui.flow.home.views.search.SearchFragment
import com.vomerc.vomerc.properties.activityBinding

class HomeActivity : AppCompatActivity() {

    private val binding by activityBinding<ActivityHomeBinding>(R.layout.activity_home)

    //private val viewModel by viewModels<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        //outState.putAll(viewModel.onSaveInstanceState())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        //viewModel.onRestoreInstanceState(savedInstanceState)
    }
}