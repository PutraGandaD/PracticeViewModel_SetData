package com.putragandad.practiceviewmodel.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.putragandad.practiceviewmodel.R
import com.putragandad.practiceviewmodel.adapters.CardOnClickListener
import com.putragandad.practiceviewmodel.adapters.ItemListAdapter
import com.putragandad.practiceviewmodel.databinding.FragmentListBinding
import com.putragandad.practiceviewmodel.models.Note
import com.putragandad.practiceviewmodel.ui.SharedViewModel
import com.putragandad.practiceviewmodel.utils.Constant

class FragmentNoteList : Fragment(), CardOnClickListener {
    private lateinit var sharedViewModel: SharedViewModel
    private var _binding : FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get viewmodels instance
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.rvFragmentlist

        sharedViewModel.data.observe(viewLifecycleOwner, Observer { item ->
            val rvAdapter = ItemListAdapter(item, this)
            recyclerView.adapter = rvAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        })

        binding.fabAddNotes.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentList_to_fragmentAddEditNote)
        }
    }

    override fun onItemClicked(item: Note) {
        // Pass notes data as bundle
        val bundle = Bundle().apply {
            putParcelable(Constant.NOTES_DATA, item)
        }

        findNavController().navigate(R.id.action_fragmentList_to_fragmentDetail, bundle)
    }
}