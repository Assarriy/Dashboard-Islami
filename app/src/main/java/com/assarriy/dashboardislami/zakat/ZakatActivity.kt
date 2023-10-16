package com.assarriy.dashboardislami.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assarriy.dashboardislami.R
import com.assarriy.dashboardislami.databinding.ActivityZakatBinding
import java.text.NumberFormat
import java.util.Locale

class ZakatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZakatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Zakat"
        actionBar.setDisplayHomeAsUpEnabled(true)

        initHitungZakat()
    }

    private fun initHitungZakat() {

        binding.btnHitung.setOnClickListener {
            var isEmptyField = false
            val totalHarta = binding.edtTotalKeseluruhanHarta.text.trim().toString()

            if (totalHarta.isEmpty()) {
                isEmptyField = true
                binding.edtTotalKeseluruhanHarta.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyField) {
                val emas = 92395000
                val persen = 0.025
                val localeID = Locale("in", "ID")
                val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)

                if (totalHarta < emas.toString()) {
                    binding.tvStatus.text = "Anda belum wajib zakat"
                    binding.tvZakatYangDikeluarkan.text = "0"
                } else {
                    val zakat = totalHarta.toInt() * persen
                    binding.tvStatus.text = "Anda wajib membayar zakat"
                    binding.tvZakatYangDikeluarkan.text = formatRupiah.format(zakat)
                }
            }

        }

    }
}