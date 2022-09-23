package com.example.android.udacityshoestoe.ui.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.android.udacityshoestoe.R
import com.example.android.udacityshoestoe.databinding.FragmentShoeDetailsBinding
import com.example.android.udacityshoestoe.models.ModelShoe

class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var viewModel: ShoeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        viewModel = ViewModelProvider(this)[ShoeViewModel::class.java]
        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this

        binding.newShoe = ModelShoe("", "", "", "")



        observeData()
        onClick()

        return binding.root
    }

    private fun observeData() {
        viewModel.isSaved.observe(viewLifecycleOwner, Observer { isSaved ->
            if (isSaved) {
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeFragment())
                viewModel.onSavedComplete()
            }

        })
    }

    private fun onClick() {
        binding.btnCancel.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeFragment())
        }
    }


}