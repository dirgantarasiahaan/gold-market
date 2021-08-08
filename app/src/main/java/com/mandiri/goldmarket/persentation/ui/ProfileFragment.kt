package com.mandiri.goldmarket.persentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mandiri.goldmarket.MainActivity
import com.mandiri.goldmarket.data.repository.ProfileRepositoryImpl
import com.mandiri.goldmarket.databinding.FragmentProfileBinding
import com.mandiri.goldmarket.persentation.viewmodel.ProfileViewModel


class ProfileFragment : Fragment() {

    var TAG = "ProfileFragment"
    private lateinit var binding: FragmentProfileBinding
    private lateinit var repository: ProfileRepositoryImpl
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("profileFragment", "Oncreate: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("profileFragment", "OnDestroy: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Pocket";
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        repository = ProfileRepositoryImpl()
        binding = FragmentProfileBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).showBottomNav()
        viewModel.setRepository(repository)
        viewModel.getData()
        subscribe()
        binding.apply {
            lifecycleOwner = this@ProfileFragment
            profileViewModel = viewModel
        }
    }


    private fun subscribe(){
        viewModel.profileLiveData.observe(requireActivity(), {
//            binding.profileName.text = it.username
//            binding.jobName.text = it.job
        })
    }
}
