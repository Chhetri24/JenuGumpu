package com.example.jenugumpu

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GradingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grading)

        val etMoisture = findViewById<EditText>(R.id.etMoisture)
        val btnCheck = findViewById<Button>(R.id.btnCheckGrade)
        val tvResult = findViewById<TextView>(R.id.tvGradeResult)

        btnCheck.setOnClickListener {
            val moistureStr = etMoisture.text.toString()
            if (moistureStr.isNotEmpty()) {
                val moisture = moistureStr.toFloat()
                when {
                    moisture < 18 -> {
                        tvResult.text = "GRADE A\n(Premium Quality)"
                        tvResult.setTextColor(Color.parseColor("#FFD700"))
                    }
                    moisture in 18.0..20.0 -> {
                        tvResult.text = "GRADE B\n(Standard Quality)"
                        tvResult.setTextColor(Color.parseColor("#FFBF00"))
                    }
                    else -> {
                        tvResult.text = "GRADE C\n(Commercial Quality)"
                        tvResult.setTextColor(Color.parseColor("#8B4513"))
                    }
                }
            }
        }
    }
}