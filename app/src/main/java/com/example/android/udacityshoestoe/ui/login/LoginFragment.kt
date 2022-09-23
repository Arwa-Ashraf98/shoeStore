package com.example.android.udacityshoestoe.ui.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Patterns
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.udacityshoestoe.R
import com.example.android.udacityshoestoe.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

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
    ): View {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClicks()
    }

    private fun onClicks() {
        binding.apply {
            btnLogin.setOnClickListener { getData() }
            btnSignUp.setOnClickListener { getData() }
        }
    }

    private fun getData() {
        binding.apply {
            val email = editEmail.text.toString().trim()
            val password = editPassword.text.toString().trim()
            validation(email, password)
        }

    }

    private fun validation(email: String, password: String) {
        binding.apply {
            if (email.isEmpty()) {
                emailTextField.error = getString(R.string.notEmpty)
                return
            } else if (password.isEmpty()) {
                passTextField.error = getString(R.string.notEmpty)
                return
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailTextField.error = getString(R.string.enterCorrectEmail)
                return
            } else if (password.length < 6) {
                passTextField.error = getString(R.string.passwordLengh)
                return
            } else {
                emailTextField.error = null
                passTextField.error = null
                navigateToNext(email)

            }
        }

    }

    private fun navigateToNext(email: String) {
        binding.apply {
            myProgress.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                myProgress.visibility = View.GONE
                view?.findNavController()?.navigate(
                    LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(
                        email
                    )
                )
            }, 2000)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (_binding != null)
            _binding = null
    }


}