package com.example.jenugumpu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnHarvest).setOnClickListener {
            startActivity(Intent(this, HarvestActivity::class.java))
        }

        findViewById<Button>(R.id.btnGrading).setOnClickListener {
            startActivity(Intent(this, GradingActivity::class.java))
        }

        findViewById<Button>(R.id.btnPrice).setOnClickListener {
            startActivity(Intent(this, PriceActivity::class.java))
        }

        findViewById<Button>(R.id.btnBatch).setOnClickListener {
            startActivity(Intent(this, BatchActivity::class.java))
        }

        findViewById<Button>(R.id.btnProfit).setOnClickListener {
            startActivity(Intent(this, ProfitActivity::class.java))
        }
    }
}