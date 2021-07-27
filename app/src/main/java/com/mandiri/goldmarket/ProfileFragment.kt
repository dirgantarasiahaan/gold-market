package com.mandiri.goldmarket

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("profileFragment", "Oncreate: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("profileFragment", "OnDestroy: ")
    }

    fun updateUsername(username: String) {
        user_profile_name.text = username
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title = "Profile";
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


}