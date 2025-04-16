package com.example.geradordesenhas

import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geradordesenhas.databinding.ActivityMainBinding
import com.example.geradordesenhas.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private var tamanho = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirmar.setOnClickListener {
            val nextScreen = Intent(this, ThirdActivity::class.java)
            nextScreen.putExtra(ThirdActivity.EXTRA_TAMANHO_SENHA, tamanho)
            startActivity(nextScreen)
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tamanho = progress.coerceAtLeast(4)
                binding.tvTamanho.text = "Tamanho da senha $tamanho"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

    }
}