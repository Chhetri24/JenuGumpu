package com.example.jenugumpu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.launch

class HarvestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harvest)

        val date = findViewById<EditText>(R.id.etDate)
        val location = findViewById<EditText>(R.id.etLocation)
        val quantity = findViewById<EditText>(R.id.etQuantity)
        val floralSource = findViewById<EditText>(R.id.etFloralSource)
        val save = findViewById<Button>(R.id.btnSave)
        val tvTotalStock = findViewById<TextView>(R.id.tvTotalStock)

        val db = AppDatabase.getDatabase(this)
        val harvestDao = db.harvestDao()
        val firebaseDb = FirebaseDatabase.getInstance().getReference("Harvests")

        updateTotalStock(harvestDao, tvTotalStock)

        save.setOnClickListener {
            val dateText = date.text.toString()
            val locationText = location.text.toString()
            val quantityText = quantity.text.toString()
            val floralSourceText = floralSource.text.toString()

            if (dateText.isEmpty() || locationText.isEmpty() || quantityText.isEmpty() || floralSourceText.isEmpty()) {
                Toast.makeText(this, getString(R.string.fill_all_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val harvest = Harvest(
                date = dateText,
                location = locationText,
                quantity = quantityText,
                floralSource = floralSourceText
            )

            lifecycleScope.launch {
                try {
                    // Save to Room
                    harvestDao.insert(harvest)
                    
                    // Save to Firebase
                    val firebaseId = firebaseDb.push().key
                    if (firebaseId != null) {
                        firebaseDb.child(firebaseId).setValue(harvest)
                    }

                    Toast.makeText(this@HarvestActivity, getString(R.string.saved_successfully), Toast.LENGTH_SHORT).show()
                    
                    date.text.clear()
                    location.text.clear()
                    quantity.text.clear()
                    floralSource.text.clear()
                    
                    updateTotalStock(harvestDao, tvTotalStock)
                } catch (e: Exception) {
                    Toast.makeText(this@HarvestActivity, "Failed: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun updateTotalStock(harvestDao: HarvestDao, tvTotalStock: TextView) {
        lifecycleScope.launch {
            val total = harvestDao.getTotalStock()
            tvTotalStock.text = "${getString(R.string.collective_stock)}: $total KG"
        }
    }
}