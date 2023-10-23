package com.assarriy.dashboardislami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.assarriy.dashboardislami.databinding.ActivityMainBinding
import com.assarriy.dashboardislami.doa.DoaActivity
import com.assarriy.dashboardislami.inspiration.InspirationData
import com.assarriy.dashboardislami.inspiration.InspirationListAdapter
import com.assarriy.dashboardislami.inspiration.InspirationModel
import com.assarriy.dashboardislami.kajian.KajianActivity
import com.assarriy.dashboardislami.zakat.ZakatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerViewInspiration()
        moveActivity()
    }

    private fun moveActivity() {
        binding.btnDoa.setOnClickListener {
            startActivity(Intent(this, DoaActivity::class.java))
        }
        binding.btnZakat.setOnClickListener {
            startActivity(Intent(this, ZakatActivity::class.java))
        }
        binding.btnVideoKajian.setOnClickListener {
            startActivity(Intent(this, KajianActivity::class.java))
        }
    }

    private fun initRecyclerViewInspiration() {
        val list: ArrayList<InspirationModel> = arrayListOf()
        binding.rvInspiration.setHasFixedSize(true)
        list.addAll(InspirationData.listData)
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        val inspirationAdapter = InspirationListAdapter(list)
        binding.rvInspiration.adapter = inspirationAdapter
    }
}