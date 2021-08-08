package com.mandiri.goldmarket.persentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.mandiri.goldmarket.MainActivity
import com.mandiri.goldmarket.R
import com.mandiri.goldmarket.databinding.FragmentWelcomeBinding
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : Fragment() {

    private  lateinit var binding : FragmentWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as MainActivity).hideBottomNav()
        binding.apply {
            mulai_button.setOnClickListener{
                findNavController().navigate(
                    R.id.signInFragment, null,
                    NavOptions.Builder().setPopUpTo(R.id.signInFragment, true).build()
                )
            }
        }
    }

}