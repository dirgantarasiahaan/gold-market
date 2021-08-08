package com.mandiri.goldmarket.persentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.mandiri.goldmarket.MainActivity
import com.mandiri.goldmarket.R
import com.mandiri.goldmarket.data.repository.PriceRepositoryImpl
import com.mandiri.goldmarket.databinding.FragmentHomeBinding
import com.mandiri.goldmarket.persentation.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    var TAG = "HomeFragment"
    private lateinit var binding: FragmentHomeBinding
    private lateinit var repository: PriceRepositoryImpl
    private lateinit var viewModel: HomeViewModel

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
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        repository = PriceRepositoryImpl()
        binding = FragmentHomeBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).showBottomNav()
        viewModel.setRepository(repository)
        viewModel.getData()
        subscribe()

        binding.apply {
            val  hasil = arguments?.getString("username")
            Log.d(TAG, "Welcome $hasil")
        }

        add_pocket.setOnClickListener{
            findNavController().navigate(
                R.id.pocketFragment, null,
                NavOptions.Builder().setPopUpTo(R.id.pocketFragment, true).build()
            )
        }
    }

    private fun subscribe(){
        viewModel.priceLiveData.observe(requireActivity(), {
            binding.priceBuy.text = it.priceBuy
            binding.priceSell.text = it.priceSell
            binding.totalPrice.text = it.totalPrice
        })
    }
}
