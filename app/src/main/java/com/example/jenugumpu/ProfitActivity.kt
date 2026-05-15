package com.example.jenugumpu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profit)

        val etQuantity = findViewById<EditText>(R.id.etQuantityProfit)
        val etCost = findViewById<EditText>(R.id.etFilteringCost)
        val btnCalc = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvProfitResult)

        btnCalc.setOnClickListener {
            val qStr = etQuantity.text.toString()
            val cStr = etCost.text.toString()
            if (qStr.isNotEmpty() && cStr.isNotEmpty()) {
                val q = qStr.toFloat()
                val c = cStr.toFloat()
                val retailPrice = 600
                val totalEarnings = q * retailPrice
                val totalCost = q * c
                val profit = totalEarnings - totalCost
                
                tvResult.text = "Estimated Profit: ₹ $profit\n(Based on ₹600/kg retail)"
            }
        }
    }
}