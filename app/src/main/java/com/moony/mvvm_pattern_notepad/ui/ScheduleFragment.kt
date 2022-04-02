package com.moony.mvvm_pattern_notepad.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.moony.mvvm_pattern_notepad.adapters.ScheduleAdapter


import com.moony.mvvm_pattern_notepad.databinding.FragmentScheduleBinding
import com.moony.mvvm_pattern_notepad.util.DateConverter
import com.moony.mvvm_pattern_notepad.viewModels.ScheduleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleFragment:Fragment() {
    private val scheduleViewModel: ScheduleViewModel by viewModels()
    private var _binding: FragmentScheduleBinding?=null
    private val binding get()=_binding!!
    private lateinit var adapter: ScheduleAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentScheduleBinding.inflate(inflater, container, false)

        //recyclerView 세팅
        binding.fragmentCalendarListView.layoutManager=LinearLayoutManager(context)
        adapter=ScheduleAdapter(scheduleViewModel)
        binding.fragmentCalendarListView.adapter=adapter


        //val dummy=Dummy_Records()
        //adapter.submitList(dummy.list)

        scheduleViewModel.currentRecord.observe(viewLifecycleOwner){ records->
            Log.d("testing","observed")
            Log.d("testing","$records")
            adapter.submitList(records)
            binding.fragmentCalendarNoListText.visibility=
                if(records.isEmpty())
                    View.VISIBLE
                else
                    View.GONE
        }

        binding.fragmentCalendarCalendar.setOnDateChangeListener{ _, year, month, day->
            Log.d("calendar","clicked")
            val date=DateConverter.convertDateToString(year,month,day)
            Log.d("date is", date)
            scheduleViewModel.setCurrentRecordByDate(date)
        }






        return binding.root

    }



    private fun getDateToString(year: Int, month: Int, day: Int): String {
        var m=month.toString()
        if (m.length<2){
            m= "0$m"
        }

        return "$year-${month + 1}-$day"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    fun init(){
        scheduleViewModel.setCurrentRecordByDate()
    }

}