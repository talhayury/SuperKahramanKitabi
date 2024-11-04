package com.talhayurt.superkahramankitabi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.talhayurt.superkahramankitabi.databinding.ActivityMainBinding
import com.talhayurt.superkahramankitabi.databinding.ActivityTanitimAktivitesiBinding

class TanitimAktivitesi : AppCompatActivity() {
    private lateinit var binding: ActivityTanitimAktivitesiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitimAktivitesiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val adapterdenGelenIntent = intent
        val secilenKahraman = adapterdenGelenIntent.getSerializableExtra("secilenKahraman") as? SuperKahraman
        if (secilenKahraman != null) {
            binding.imageView2.setImageResource(secilenKahraman.resim)
            binding.isimtext.text = secilenKahraman.isim
            binding.meslekText.text = secilenKahraman.meslek
        } else {
            // Hata durumunu ele alın, örneğin bir hata mesajı gösterin veya varsayılan bir davranış sergileyin.
            binding.isimtext.text = "Bilinmeyen Kahraman"
            binding.meslekText.text = "Bilinmeyen Meslek"
        }
        //binding.imageView2.setImageResource(secilenKahraman.resim)
        //binding.isimtext.text = secilenKahraman.isim
        //binding.meslekText.text = secilenKahraman.meslek
    }
}