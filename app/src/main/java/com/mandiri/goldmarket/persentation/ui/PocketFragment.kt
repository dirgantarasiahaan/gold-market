package com.mandiri.goldmarket.persentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mandiri.goldmarket.MainActivity
import com.mandiri.goldmarket.adapter.PocketAdapter
import com.mandiri.goldmarket.data.model.Pocket
import com.mandiri.goldmarket.data.repository.PocketRepository
import com.mandiri.goldmarket.data.repository.PocketRepositoryImpl
import com.mandiri.goldmarket.databinding.FragmentPocketBinding
import com.mandiri.goldmarket.persentation.viewmodel.PocketViewModel
import com.mandiri.goldmarket.utils.EventResult


class PocketFragment : Fragment(), PocketAdapter.OnClickListener {

    var TAG = "PocketFragment"
    private lateinit var binding: FragmentPocketBinding
    private lateinit var pocketAdapter: PocketAdapter
    private lateinit var repository: PocketRepository
    private lateinit var viewModel: PocketViewModel
    private var listPocket = ArrayList<Pocket>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Pocket";
        repository = PocketRepositoryImpl()
        binding = FragmentPocketBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(PocketViewModel::class.java)
        pocketAdapter = PocketAdapter(listPocket, this)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideBottomNav()
        viewModel.setRepository(repository)
        viewModel.start()
        subscriber()

        binding.apply {
            recycleViewPocket.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = pocketAdapter
            }
            btnAddPocket.setOnClickListener{
                showProgressBar()
                val pocketName = editTextPocket.text
                viewModel.addPocket(Pocket("$pocketName", 0))
                viewModel.start()
            }
        }
    }


    private fun subscriber(){
        binding.apply {
            val pocketObserver: Observer<EventResult> = Observer<EventResult> { event ->
                Log.d(TAG, event.toString())
                when( event ){
                    is EventResult.Loading -> Log.d(TAG, "Loading...")
                    is EventResult.Success -> {
                        pocketAdapter.updateData(event.data as List<Pocket>)
                        listPocket = event.data as ArrayList<Pocket>
                        hideProgressBar()
                    }
                    is EventResult.Failed -> Log.d(TAG, "Failed, Try again")
                    else -> {}
                }
            }
            viewModel.pocketLiveData.observe(viewLifecycleOwner, pocketObserver)
        }
    }

    override fun onClickItem(position: Int) {
        Toast.makeText(context, "${listPocket[position].pocketName} total ${listPocket[position].pocketQuantity}/gram", Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteItem(position: Int) {
        viewModel.delPocket(position)
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

}

