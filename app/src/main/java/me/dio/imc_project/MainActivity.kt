package me.dio.imc_project

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.internal.ViewUtils.getContentView
import me.dio.imc_project.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }
    private fun setListeners() {
        binding.tiAltura.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_LONG).show()
        }
        binding.tiPeso.doOnTextChanged { text, start, before, count ->
           // binding.tvIMC.text = text
        }
        binding.btnCalcular.setOnClickListener {
            calcularIMC(binding.tiPeso.text.toString(), binding.tiAltura.text.toString())
        }
    }
    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso !=null && altura != null) {
            val imc = peso / (altura * altura)
            binding.tvIMC.text = "Seu IMC é: %.2f".format(imc)
        }
    }

}



