
package com.assarriy.dashboardislami.kajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.assarriy.dashboardislami.R
import com.assarriy.dashboardislami.databinding.ActivityKajianBinding
import com.assarriy.dashboardislami.kajian.adapter.KajianAdapter
import com.assarriy.dashboardislami.kajian.data.KajianData
import com.assarriy.dashboardislami.kajian.model.KajianModel

class KajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKajianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvKajian.layoutManager = LinearLayoutManager(this)
        binding.rvKajian.setHasFixedSize(true)
        val listKajian = ArrayList<KajianModel>()
        listKajian.addAll(KajianData.listData)
        binding.rvKajian.adapter = KajianAdapter(listKajian)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}