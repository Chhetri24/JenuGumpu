package com.example.jenugumpu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BatchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batch)

        val etDate = findViewById<EditText>(R.id.etBatchDate)
        val etLoc = findViewById<EditText>(R.id.etBatchLoc)
        val btnGen = findViewById<Button>(R.id.btnGenerateBatch)
        val tvBatchID = findViewById<TextView>(R.id.tvBatchID)

        btnGen.setOnClickListener {
            val date = etDate.text.toString()
            val loc = etLoc.text.toString()
            if (date.isNotEmpty() && loc.isNotEmpty()) {
                val batchId = "BATCH-${loc.uppercase()}-$date"
                tvBatchID.text = batchId
            }
        }
    }
}