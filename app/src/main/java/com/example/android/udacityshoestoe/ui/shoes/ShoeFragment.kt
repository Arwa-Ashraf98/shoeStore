package com.example.android.udacityshoestoe.ui.shoes

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.android.udacityshoestoe.R
import com.example.android.udacityshoestoe.databinding.FragmentShoeBinding
import com.example.android.udacityshoestoe.databinding.ItemShoeBinding

class ShoeFragment : Fragment() {
    private var _binding: FragmentShoeBinding? = null
    private val binding get() = _binding
    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe, container, false)
        shoeViewModel = ViewModelProvider(this)[ShoeViewModel::class.java]

        shoeViewModel.listOfShoes.observe(viewLifecycleOwner, Observer { listOfShoes ->
            for (shoeItem in listOfShoes) {

                val itemBinding: ItemShoeBinding = DataBindingUtil.inflate(
                    layoutInflater, R.layout.item_shoe, container, false
                )

                itemBinding.tvShoeName.text = shoeItem.shoeName

                itemBinding.tvShoeCompany.text = shoeItem.shoeCompany

                itemBinding.tvShoeSize.text = shoeItem.shoeSize

                itemBinding.tvShoeDescription.text = shoeItem.shoeSize


                binding?.shoesListLinear?.addView(itemBinding.root)
            }
        })


        onClicks()

        return binding?.root
    }

    private fun onClicks() {
        binding?.btnAdd?.setOnClickListener {
            findNavController().navigate(ShoeFragmentDirections.actionShoeFragmentToShoeDetailsFragment())
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = requireActivity().findNavController(R.id.fragmentContainerView)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        if (_binding != null) {
            _binding = null
        }
    }


}