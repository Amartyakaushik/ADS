package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sampleapp.databinding.ActivityTimeRangePickerBinding
import nl.joery.timerangepicker.TimeRangePicker

class TimeRangePickerActivity : AppCompatActivity() {
    private val binding:ActivityTimeRangePickerBinding by lazy {
        ActivityTimeRangePickerBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.picker.setOnTimeChangeListener(object : TimeRangePicker.OnTimeChangeListener {
            override fun onStartTimeChange(startTime: TimeRangePicker.Time) {
                Log.d("TimeRangePicker", "Start time: " + startTime)
            }

            override fun onEndTimeChange(endTime: TimeRangePicker.Time) {
                Log.d("TimeRangePicker", "End time: " + endTime.hour)
            }

            override fun onDurationChange(duration: TimeRangePicker.TimeDuration) {
                Log.d("TimeRangePicker", "Duration: " + duration.hour)
            }
        })
    }
}
