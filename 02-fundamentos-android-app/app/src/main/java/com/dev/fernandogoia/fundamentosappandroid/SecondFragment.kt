package com.dev.fernandogoia.fundamentosappandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dev.fernandogoia.fundamentosappandroid.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DiceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstArgument = arguments?.getStringArray("first_arg") ?: arrayOf()

        Log.d("SecondFragment", "Argument ${firstArgument.joinToString()}")

        lifecycleScope.launch {
            viewModel.uiState.collect {
                // Update UI elements

                binding.tvSecondFragment.text = it.rolledDieValue?.toString()

            }
        }
    }
}