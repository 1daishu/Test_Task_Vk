package com.shubin.testtaskvk.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shubin.testtaskvk.data.network.ProductX
import com.shubin.testtaskvk.databinding.FragmentTapeBinding
import com.shubin.testtaskvk.ui.adapter.TypeAdapter
import com.shubin.testtaskvk.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TapeFragment : Fragment() {

    private lateinit var binding: FragmentTapeBinding
    private val viewModel: ProductViewModel by viewModels()
    private val typeAdapter = TypeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTapeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getProduct()
        getRecyclerProduct()
    }

    private fun getRecyclerProduct() {
        binding.rvProduct.apply {
            layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            adapter = typeAdapter
        }
    }

    private fun getProduct() {
        viewModel.getAllProduct()
        viewModel.getProduct.observe(viewLifecycleOwner) {
            typeAdapter.submitList(it)
        }
    }
}