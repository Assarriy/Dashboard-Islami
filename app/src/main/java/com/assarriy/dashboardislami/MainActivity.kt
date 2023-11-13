package com.assarriy.dashboardislami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.assarriy.dashboardislami.databinding.ActivityMainBinding
import com.assarriy.dashboardislami.doa.DoaActivity
import com.assarriy.dashboardislami.inspiration.InspirationData
import com.assarriy.dashboardislami.inspiration.InspirationListAdapter
import com.assarriy.dashboardislami.inspiration.InspirationModel
import com.assarriy.dashboardislami.kajian.KajianActivity
import com.assarriy.dashboardislami.shalat.ShalatActivity
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
            startActivity(Intent(this@MainActivity, DoaActivity::class.java))
        }
        binding.btnZakat.setOnClickListener {
            startActivity(Intent(this@MainActivity, ZakatActivity::class.java))
        }
        binding.btnVideoKajian.setOnClickListener {
            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity, KajianActivity::class.java))
        }
        binding.btnJadwalShalat.setOnClickListener {
            startActivity(Intent(this@MainActivity, ShalatActivity::class.java))
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