package com.assarriy.dashboardislami.doa

import android.content.Intent
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

        intentTolistActivity()

    }

    private fun intentTolistActivity() {
        binding.cardDoaPagiMalam.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, "Doa Pagi & Malam")
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_pagi_malam)
            startActivity(intent)
        }
        binding.cardDoaRumah.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, "Doa Rumah")
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_rumah)
            startActivity(intent)
        }
        binding.cardMakananMinuman.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, "Makanan Dan Minuman")
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_makanan_minuman)
            startActivity(intent)
        }
        binding.cardDoaPerjalanan.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, "Doa Perjalanan")
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_perjalanan)
            startActivity(intent)
        }
        binding.cardDoaShalat.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, "Doa Shalat")
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_sholat)
            startActivity(intent)
        }
        binding.cardEtikaBaik.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, "Etika Baik")
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_etika_baik)
            startActivity(intent)
        }
    }

    //    button back
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}