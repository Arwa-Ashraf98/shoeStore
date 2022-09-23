package com.example.android.udacityshoestoe.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.udacityshoestoe.BaseFragment
import com.example.android.udacityshoestoe.R
import com.example.android.udacityshoestoe.databinding.FragmentWelcomeBinding


class WelcomeFragment : BaseFragment() {
    private lateinit var email: String
    private var _binding: FragmentWelcomeBinding? = null
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
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        email = WelcomeFragmentArgs.fromBundle(
            requireArguments()
        ).email
        initUserName(email)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClicks()
    }

    private fun onClicks() {
        binding?.apply {
            btnNext.setOnClickListener {
                it.findNavController()
                    .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstrctionFragment())
            }
        }
    }

    private fun initUserName(email: String) {
        binding?.textEmail?.text = email
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (_binding != null)
            _binding = null
    }


}