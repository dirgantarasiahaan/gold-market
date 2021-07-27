package com.mandiri.goldmarket

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HistoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HistoryFragment", "OnCreate: ")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("HistoryFragment", "OnDestroy: ")
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title = "History";
        return inflater.inflate(R.layout.fragment_history, container, false)
    }




}