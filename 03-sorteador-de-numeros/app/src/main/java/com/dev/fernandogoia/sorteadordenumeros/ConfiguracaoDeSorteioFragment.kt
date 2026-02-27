package com.dev.fernandogoia.sorteadordenumeros

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.core.widget.addTextChangedListener
import com.dev.fernandogoia.sorteadordenumeros.databinding.FragmentConfiguracaoDeSorteioBinding

class ConfiguracaoDeSorteioFragment : Fragment() {

    private var _binding: FragmentConfiguracaoDeSorteioBinding? = null
    private val binding get() = _binding!!

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfiguracaoDeSorteioBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            swtNotRepeatNumbers.setOnCheckedChangeListener { _, isChecked ->
                swtNotRepeatNumbers.trackTintList =
                    getColorStateList(
                        requireContext(),
                        if (isChecked) R.color.background_brand else R.color.content_tertiary
                    )
            }

            etAmountNumbers.addTextChangedListener { text ->

            }

            etFromLimit.addTextChangedListener { text ->

            }

            etFinalLimit.addTextChangedListener { text ->

            }

        }
    }
}