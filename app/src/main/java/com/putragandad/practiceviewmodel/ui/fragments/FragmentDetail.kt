package com.putragandad.practiceviewmodel.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.putragandad.practiceviewmodel.databinding.FragmentDetailBinding
import com.putragandad.practiceviewmodel.models.Note
import com.putragandad.practiceviewmodel.ui.SharedViewModel
import com.putragandad.practiceviewmodel.utils.Constant

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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notesBundle = arguments?.getParcelable<Note>(Constant.NOTES_DATA)
        val notesTitle = notesBundle?.title.toString()
        val notesContent = notesBundle?.content.toString()
        binding.tvDetailTitle.setText(notesTitle) // set Notes Title from Bundle (if available)
        binding.tvDetailDesc.setText(notesContent) // set Notes Content from Bundle (if available)
    }
}