package com.mandiri.goldmarket.persentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.mandiri.goldmarket.MainActivity
import com.mandiri.goldmarket.R
import com.mandiri.goldmarket.databinding.FragmentSignInBinding
import com.mandiri.goldmarket.databinding.FragmentSignUpBinding
import com.mandiri.goldmarket.persentation.viewmodel.AuthViewModel
import com.mandiri.goldmarket.utils.EventResult
import java.util.*


class SignUpFragment : Fragment() {

    private lateinit var binding : FragmentSignUpBinding
    private lateinit var viewModel : AuthViewModel
    private val TAG = "SignUpFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as MainActivity).hideBottomNav()
        hideProgressBar()
        subscriber()
        binding.apply {
            btnRegister.setOnClickListener{
                showProgressBar()
                viewModel.updateInfo()
            }
            btnSignin.setOnClickListener{
                Navigation.findNavController(view).navigate(R.id.signInFragment)
            }
        }
    }

    private fun subscriber(){
        binding.apply {
            val userObserver: Observer<EventResult> = Observer<EventResult> { event ->
                Log.d("Main", event.toString())
                when( event ){
                    is EventResult.Loading -> Log.d(TAG, "Loading...")

                    is EventResult.Success -> {
                        val name = usernameText
                        var bundle = bundleOf("username" to name.toString())
                        hideProgressBar()

                        findNavController().navigate(R.id.homeFragment, bundle,
                            NavOptions.Builder().setPopUpTo(R.id.homeFragment, true).build())
                    }
                    is EventResult.Failed -> Log.d(TAG, "Failed, Try again")
                }
            }
            viewModel.userLiveData.observe(requireActivity(), userObserver)
        }
    }


    private fun hideProgressBar() {
        Log.d(TAG, "HideProgressBar: ")
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        Log.d(TAG, "ShowProgressBar: ")
        binding.progressBar.visibility = View.VISIBLE
    }
}