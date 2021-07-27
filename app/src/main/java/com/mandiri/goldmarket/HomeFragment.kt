package com.mandiri.goldmarket

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("homeFragment", "OnCreate: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("homeFragment", "OnDestroy: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Home";
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_pocket.setOnClickListener{
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_pocketFragment)
        }
    }



}