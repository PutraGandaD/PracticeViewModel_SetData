package com.putragandad.practiceviewmodel.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.putragandad.practiceviewmodel.R
import com.putragandad.practiceviewmodel.databinding.FragmentAddEditNoteBinding
import com.putragandad.practiceviewmodel.databinding.FragmentDetailBinding
import com.putragandad.practiceviewmodel.models.Note
import com.putragandad.practiceviewmodel.ui.SharedViewModel

class FragmentAddEditNote : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel

    private var _binding : FragmentAddEditNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddEditNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get viewmodels instance
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabSaveNotes.setOnClickListener {
            // get text from the editText
            val noteTitle = binding.tfNotesTitle.editText?.text.toString()
            val noteContent = binding.tfNotesContent.editText?.text.toString()

            sharedViewModel.addData(Note(noteTitle, noteContent))
            findNavController().popBackStack()
        }
    }
}