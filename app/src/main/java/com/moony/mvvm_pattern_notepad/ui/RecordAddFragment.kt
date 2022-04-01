package com.moony.mvvm_pattern_notepad.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.moony.mvvm_pattern_notepad.R
import com.moony.mvvm_pattern_notepad.databinding.FragmentRecordAddBinding
import com.moony.mvvm_pattern_notepad.databinding.FragmentRecordSubjectListBinding
import com.moony.mvvm_pattern_notepad.databinding.FragmentSubjectAddBinding
import com.moony.mvvm_pattern_notepad.viewModels.RecordViewModel


class RecordAddFragment: Fragment() {
    private var _binding: FragmentRecordAddBinding?=null
    private val binding:FragmentRecordAddBinding
        get()=_binding!!

    private val viewModel:RecordViewModel by viewModels(ownerProducer = {requireParentFragment()})


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=DataBindingUtil.inflate<FragmentRecordAddBinding>(
            inflater,
            R.layout.fragment_subject_add,
            container,
            false
        ).apply {
            //데이터 바인딩에 viewModel 설정
            vm=viewModel
        }

        return binding.root
    }

}