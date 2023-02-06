package com.mandocarrilloh.melidemo.ui.flow.home.views.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.mandocarrilloh.domain.entity.AtributesEntity
import com.mandocarrilloh.domain.entity.PicturesEntity
import com.mandocarrilloh.domain.entity.ProductEntity
import com.mandocarrilloh.melidemo.R
import com.mandocarrilloh.melidemo.databinding.FragmentDetailBinding
import com.mandocarrilloh.melidemo.ui.base.BaseFragment
import com.mandocarrilloh.melidemo.ui.item_views.AttributeItemView
import com.mandocarrilloh.melidemo.ui.item_views.ImageDetaiItemView
import com.vomerc.vomerc.properties.fragmentBinding
import com.xwray.groupie.GroupieAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailFragment : BaseFragment() {

    private val binding by fragmentBinding<FragmentDetailBinding>(R.layout.fragment_detail)

    private val viewModel: DetailViewModel by sharedViewModel()

    private val adapter by lazy { GroupieAdapter() }

    private val adapterAttributes by lazy { GroupieAdapter() }

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        setStatusBarColor(R.color.colorPrimary)
        initView()
        subscribeViewModel()
        return binding.root
    }

    private fun initView() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.root.isVisible = false
        binding.recyclerViewImages.adapter = adapter
        binding.recyclerViewAttributes.adapter = adapterAttributes
        binding.recyclerViewImages.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerViewImages)
        binding.toolbar.imageViewArrow.setOnClickListener { findNavController().popBackStack() }
    }

    private fun subscribeViewModel() {
        subscribeViewModel(viewModel, binding.root)
        viewModel.product.observe(viewLifecycleOwner, ::loadProduct)
        viewModel.init(args.itemId)
    }

    private fun loadProduct(product: ProductEntity) {
        binding.root.isVisible = true
        product.pictures?.let { loadPicturesProduct(it) }
        product.attributes?.let { loadAttributesProduct(it) }
    }

    private fun loadPicturesProduct(pictures: List<PicturesEntity>) {
        adapter.update(
            pictures.map {
                ImageDetaiItemView(it.url.orEmpty(), pictures.size)
            }
        )
        binding.recyclerViewImages.stopScroll()
    }

    private fun loadAttributesProduct(attributes: List<AtributesEntity>) {
        adapterAttributes.update(
            attributes.map { AttributeItemView(it) }
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putAll(viewModel.onSaveInstanceState())
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let { viewModel.onRestoreInstanceState(it) }
    }
}