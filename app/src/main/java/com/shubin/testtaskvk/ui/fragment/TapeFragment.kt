package com.shubin.testtaskvk.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shubin.testtaskvk.databinding.FragmentTapeBinding

class TapeFragment : Fragment() {

    private lateinit var binding: FragmentTapeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTapeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}