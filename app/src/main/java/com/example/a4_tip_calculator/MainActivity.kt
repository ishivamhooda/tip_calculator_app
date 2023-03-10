package com.example.a4_tip_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a4_tip_calculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{ calculateTip() }



    }



        fun calculateTip() {
            val stringInTextField = binding.costOfService.text.toString()
            val cost = stringInTextField.toDouble()

            val selectedId = binding.tipsOptions.checkedRadioButtonId
            val tipPercentage = when (selectedId) {
                R.id.option_20_percent -> 0.20
                R.id.option_18_percent -> 0.18
                else -> 0.15
            }

            var tip = tipPercentage * cost
            val roundUp = binding.roundAppSwitch.isChecked
            if (roundUp) {
                tip = kotlin.math.ceil(tip)
            }

            val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
            binding.tipResult.text = getString(R.string.tip_amount, formattedTip)

        }





    }
