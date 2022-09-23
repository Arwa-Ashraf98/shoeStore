package com.example.android.udacityshoestoe.ui.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.android.udacityshoestoe.BaseFragment
import com.example.android.udacityshoestoe.databinding.FragmentInstructionBinding

class InstructionFragment : BaseFragment() {
    private var _binding: FragmentInstructionBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.clear()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInstructionBinding.inflate(layoutInflater)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClicks()
    }

    private fun onClicks() {
        binding?.btnNavigate?.setOnClickListener {
            it.findNavController()
                .navigate(InstructionFragmentDirections.actionInstrctionFragmentToShoeFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (_binding != null) {
            _binding = null
        }
    }


}