package com.mandiri.goldmarket.persentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mandiri.goldmarket.MainActivity
import com.mandiri.goldmarket.adapter.HistoryAdapter
import com.mandiri.goldmarket.data.model.History
import com.mandiri.goldmarket.data.repository.HistoryRepository
import com.mandiri.goldmarket.data.repository.HistoryRepositoryImpl
import com.mandiri.goldmarket.databinding.FragmentHistoryBinding
import com.mandiri.goldmarket.persentation.viewmodel.HistoryViewModel
import com.mandiri.goldmarket.utils.EventResult

class HistoryFragment : Fragment(), HistoryAdapter.OnClickListener {

    var TAG = "HistoryFragment"
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var repository: HistoryRepository
    private lateinit var viewModel: HistoryViewModel
    private var listHistory = ArrayList<History>()

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
        activity?.title = "History";
        repository = HistoryRepositoryImpl()
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)
        historyAdapter = HistoryAdapter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as MainActivity).showBottomNav()
        viewModel.setRepository(repository)
        viewModel.start()
        subscriber()

        binding.apply {
            recycleViewHistory.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = historyAdapter
            }

        }
    }

    private fun subscriber(){
        binding.apply {
            val historyObserver: Observer<EventResult> = Observer<EventResult> { event ->
                Log.d(TAG, event.toString())
                when( event ){
                    is EventResult.Loading -> Log.d(TAG, "Loading...")
                    is EventResult.Success -> {
                        historyAdapter.updateData(event.data as List<History>)
                        listHistory = event.data as ArrayList<History>
                        hideProgressBar()
                    }
                    is EventResult.Failed -> Log.d(TAG, "Failed, Try again")
                    else -> {}
                }
            }
            viewModel.historyLiveData.observe(viewLifecycleOwner, historyObserver)
        }
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onClickItem(position: Int) {
        Toast.makeText(context, "${listHistory[position].transaction}  ${listHistory[position].date} ", Toast.LENGTH_SHORT).show()
    }

}