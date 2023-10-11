package com.assarriy.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.assarriy.dashboardislami.R
import com.assarriy.dashboardislami.databinding.ActivityDetailListDoaBinding
import com.assarriy.dashboardislami.databinding.ActivityDoaBinding
import com.assarriy.dashboardislami.doa.adapter.DoaListAdapter
import com.assarriy.dashboardislami.doa.data.DoaEtikaBaik
import com.assarriy.dashboardislami.doa.data.DoaMakananMinuman
import com.assarriy.dashboardislami.doa.data.DoaPagiMalam
import com.assarriy.dashboardislami.doa.data.DoaPerjalanan
import com.assarriy.dashboardislami.doa.data.DoaRumah
import com.assarriy.dashboardislami.doa.data.DoaShalat
import com.assarriy.dashboardislami.doa.model.DoaModel

class ListDoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailListDoaBinding
    lateinit var title: String
    private var logo: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailListDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra(EXTRA_TITLE).toString()
        logo = intent.getIntExtra(EXTRA_IMAGE, 0)

        val actionBar = supportActionBar
        actionBar?.title = intent.getStringExtra(EXTRA_TITLE)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val list: ArrayList<DoaModel> = arrayListOf()
        when (title) {
            getString(R.string.pagi_dan_malam) -> {
                list.addAll(DoaPagiMalam.listDoaPagiDanMalam)
            }

            getString(R.string.rumah) -> {
                list.addAll(DoaRumah.listDoaRumah)
            }

            getString(R.string.makanan_dan_minuman) -> {
                list.addAll(DoaMakananMinuman.listDoaMakananDanMinuman)
            }

            getString(R.string.perjalanan) -> {
                list.addAll(DoaPerjalanan.listDoaPerjalanan)
            }

            getString(R.string.shalat) -> {
                list.addAll(DoaShalat.listDoaShalat)
            }

            getString(R.string.etika_baik) -> {
                list.addAll(DoaEtikaBaik.listDoaEtikaBaik)
            }
        }
        binding.rvListDoa.hasFixedSize()
        binding.rvListDoa.layoutManager = LinearLayoutManager(this)
        val adapter = DoaListAdapter(list, title, logo)
        binding.rvListDoa.adapter = adapter
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_IMAGE = "extra_image"
    }
}