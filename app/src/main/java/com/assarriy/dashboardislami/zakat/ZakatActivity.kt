package com.assarriy.dashboardislami.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assarriy.dashboardislami.R
import com.assarriy.dashboardislami.databinding.ActivityZakatBinding

class ZakatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZakatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initHitungZakat()
    }

    private fun initHitungZakat() {

        binding.btnHitung.setOnClickListener {
            var isEmptyField = false
            val totalHarta = binding.edtTotalKeseluruhanHarta.text.trim().toString()

            if (totalHarta.isEmpty()){
                !isEmptyField
                binding.edtTotalKeseluruhanHarta.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyField){
                val emas = 92395000
                val persen = 0.025

                if(totalHarta < emas.toString()) {
                    binding.tvStatus.text = "Anda belum wajib zakat"
                } else {
                    val zakat = totalHarta.toDouble() * persen
                    binding.tvStatus.text = "Anda wajib membayar zakat"
                    binding.tvZakatYangDikeluarkan.text = "Rp. $zakat"
                }
            }

        }

    }
}