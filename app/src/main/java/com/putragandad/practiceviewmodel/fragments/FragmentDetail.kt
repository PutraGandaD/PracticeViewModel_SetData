package com.putragandad.practiceviewmodel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.putragandad.practiceviewmodel.R
import com.putragandad.practiceviewmodel.databinding.FragmentDetailBinding
import com.putragandad.practiceviewmodel.viewmodels.SharedViewModel

class FragmentDetail : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get viewmodels instance
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // observe sharedViewModel data
        sharedViewModel.data.observe(this, Observer { item ->
            binding.tvDetailTitle.text = item.name
            binding.tvDetailDesc.text = item.description
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}