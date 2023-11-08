package com.assarriy.dashboardislami.shalat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.assarriy.dashboardislami.R
import com.assarriy.dashboardislami.databinding.ActivityKajianBinding
import com.assarriy.dashboardislami.databinding.ActivitySholatBinding
import com.loopj.android.http.AsyncHttpClient
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.log

class ShalatActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySholatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initShalatView()
        getPrayTimeData("1411")
    }

    private fun getPrayTimeData(location: String) {
        val calendar = Calendar.getInstance()
        val tanggal = calendar.get(Calendar.DAY_OF_MONTH)
        val bulan = calendar.get(Calendar.MONTH)
        val tahun = calendar.get(Calendar.YEAR)
        val client = AsyncHttpClient()
        val url = "https://api.myquran.com/v1/sholat/jadwal/$location/$tahun/$bulan/$tanggal"
        Log.d("ShalatActivity", "getPrayTimeData: $url")
    }

    private fun initShalatView() {
        val waktu = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(waktu)

        /*Menampilkan Tanggal Sekarang*/
        binding.tvDatePray.text = formattedDate
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}