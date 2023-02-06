package com.mandocarrilloh.melidemo.ui.flow.home.views.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.mandocarrilloh.domain.entity.ProductEntity
import com.mandocarrilloh.melidemo.R
import com.mandocarrilloh.melidemo.databinding.FragmentSearchBinding
import com.mandocarrilloh.melidemo.ui.base.BaseFragment
import com.mandocarrilloh.melidemo.ui.flow.home.views.suggestion.SuggestionViewModel
import com.mandocarrilloh.melidemo.ui.item_views.ProductItemView
import com.vomerc.vomerc.properties.fragmentBinding
import com.xwray.groupie.Group
import com.xwray.groupie.GroupieAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SearchFragment : BaseFragment() {

    private val binding by fragmentBinding<FragmentSearchBinding>(R.layout.fragment_search)

    private val viewModel: SearchViewModel by sharedViewModel()

    private val suggestionViewModel: SuggestionViewModel by sharedViewModel()

    private val adapter by lazy { GroupieAdapter() }

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
        binding.recyclerProducts.adapter = adapter
        binding.toolbar.editTextSearch.setOnClickListener {
            findNavController().navigate(SearchFragmentDirections.toSuggestion())
        }
    }

    private fun subscribeViewModel() {
        subscribeViewModel(viewModel, binding.root)
        suggestionViewModel.suggestionSelected.observe(viewLifecycleOwner, ::getSearchProducts)
        viewModel.products.observe(viewLifecycleOwner, ::loadProducts)
    }

    private fun getSearchProducts(suggestions: String) {
        binding.toolbar.editTextSearch.setText(suggestions)
        viewModel.getSearchProducts(suggestions)
    }

    private fun loadProducts(products: List<ProductEntity>) {
        adapter.clear()
        val items = mutableListOf<Group>()
        items.addAll(products.map { ProductItemView(it, ::onProductSelected) })

        val isVisible = products.isEmpty()
        binding.recyclerProducts.isVisible = !isVisible
        binding.textViewNotFound.isVisible = isVisible
        adapter.addAll(items)
    }

    private fun onProductSelected(product: ProductEntity) {
        findNavController().navigate(SearchFragmentDirections.toDetail(product.id.orEmpty()))
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