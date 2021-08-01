package com.mandiri.goldmarket.persentation.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.mandiri.goldmarket.MainActivity
import com.mandiri.goldmarket.R

class SplashScreenFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideBottomNav()
        Handler().postDelayed({
            Navigation.findNavController(view).navigate(R.id.action_splashScreenFragment_to_welcomeFragment)
        }, 2000)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SplashScreenFragment()

    }
}