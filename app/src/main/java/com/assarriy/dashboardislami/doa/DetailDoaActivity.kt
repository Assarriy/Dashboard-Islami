package com.assarriy.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assarriy.dashboardislami.R
import com.assarriy.dashboardislami.databinding.ActivityDetailDoaBinding
import com.assarriy.dashboardislami.doa.model.DoaModel

class DetailDoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailDoaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val doa = intent.getParcelableExtra<DoaModel>(EXTRA_DOA) as DoaModel
        val actionBar = supportActionBar
        actionBar!!.title = doa.title
        actionBar.setDisplayHomeAsUpEnabled(true)

        binding.tvTitle.text = doa.title
        binding.tvDoa.text = doa.doa
        binding.tvLatin.text = doa.latin
        binding.tvTranslate.text = doa.translate
        binding.tvPerawi.text = doa.profile
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    companion object {
        const val EXTRA_DOA = "extra_doa"
    }
}