package com.example.clase_17_prefcompartidas_viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.example.clase_17_prefcompartidas_viewmodel.databinding.ActivityMainBinding
import com.example.clase_17_prefcompartidas_viewmodel.databinding.ActivitySystemBinding

class system : AppCompatActivity() {
    lateinit var vista:ActivitySystemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vista= ActivitySystemBinding.inflate(layoutInflater)
        setContentView(vista.root)
        val manager = PreferenceManager.getDefaultSharedPreferences(this)

        //BORRAMOS LA CLAVE GUARDADA EN EL LOGIN
        vista.btnCerrar.setOnClickListener {
            val borremoj = manager.edit()
            borremoj.remove("Login")
            borremoj.commit()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}