package com.putragandad.practiceviewmodel.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.putragandad.practiceviewmodel.R
import com.putragandad.practiceviewmodel.adapters.CardOnClickListener
import com.putragandad.practiceviewmodel.adapters.ItemListAdapter
import com.putragandad.practiceviewmodel.models.Item
import com.putragandad.practiceviewmodel.ui.SharedViewModel

class FragmentList : Fragment(), CardOnClickListener {
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get viewmodels instance
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.data.observe(viewLifecycleOwner, Observer { item ->
            val rvAdapter = ItemListAdapter(item, this)
            val recyclerView: RecyclerView = view.findViewById(R.id.rv_fragmentlist)
            recyclerView.adapter = rvAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        })
    }

    override fun onItemClicked(item: Item) {
//        sharedViewModel.setData(item)
        findNavController().navigate(R.id.action_fragmentList_to_fragmentDetail)
    }
}