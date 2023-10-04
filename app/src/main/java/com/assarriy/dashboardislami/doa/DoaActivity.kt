package com.assarriy.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assarriy.dashboardislami.R
import com.assarriy.dashboardislami.databinding.ActivityDoaBinding
import com.assarriy.dashboardislami.databinding.ActivityMainBinding

class DoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        action bar
        val actionBar = supportActionBar
        actionBar!!.title = "Doa Harian"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

    }

//    button back
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}