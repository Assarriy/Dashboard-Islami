package com.assarriy.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assarriy.dashboardislami.R
import com.assarriy.dashboardislami.databinding.ActivityDoaBinding

class DetailDoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}