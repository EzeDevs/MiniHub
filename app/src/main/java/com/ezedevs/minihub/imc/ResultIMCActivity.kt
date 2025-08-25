package com.ezedevs.minihub.imc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ezedevs.minihub.R
import com.ezedevs.minihub.imc.CalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvInfo: TextView
    private lateinit var btnRecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)

        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when (result) {
            in 0.00..17.99 -> { // Bajo peso
                tvResult.text = getString(R.string.title_underweight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.underweight))
                tvInfo.text = getString(R.string.info_underweight)
            }

            in 18.00..24.99 -> { // Peso Normal
                tvResult.text = getString(R.string.title_normal_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                tvInfo.text = getString(R.string.info_normal_weight)
            }

            in 25.00..29.99 -> { // Sobrepeso
                tvResult.text = getString(R.string.title_overweight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.overweight))
                tvInfo.text = getString(R.string.info_overweight)
            }

            in 30.00..34.99 -> { // Obesidad grado 1
                tvResult.text = getString(R.string.title_obesity_1)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity_1))
                tvInfo.text = getString(R.string.info_obesity_1)
            }

            in 35.00..39.99 -> { // Obesidad grado 2
                tvResult.text = getString(R.string.title_obesity_2)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity_2))
                tvInfo.text = getString(R.string.info_obesity_2)
            }

            in 40.00..99.99 -> { // Obesidad grado 3
                tvResult.text = getString(R.string.title_obesity_3)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity_3))
                tvInfo.text = getString(R.string.info_obesity_3)
            }

            else -> { // Error
                tvResult.text = getString(R.string.title_error_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.error_weight))
                tvInfo.text = getString(R.string.info_error_weight)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvInfo = findViewById(R.id.tvInfo)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }
}