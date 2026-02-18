package com.dev.fernandogoia.fundamentosappandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.dev.fernandogoia.fundamentosappandroid.databinding.FragmentFirstBinding
import com.dev.fernandogoia.fundamentosappandroid.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch
import kotlin.getValue

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DiceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                uiState.rolledDice2ImgRes?.let { imgRes ->
                    binding.ivRolledDice2.setImageResource(imgRes)
                }
            }
        }
    }

}