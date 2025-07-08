package com.ezedevs.minihub.saludapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ezedevs.minihub.R
import com.ezedevs.minihub.saludapp.ResultActivity

class SaludAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_salud_app)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val etName = findViewById<EditText>(R.id.etName)

        btnStart.setOnClickListener {
            // Acción al hacer clic en el botón
            val name = etName.text.toString()

            // Verificamos que el nombre no esté vacío
            if (name.isNotEmpty()) {
                intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}