package com.example.clase_17_prefcompartidas_viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.preference.PreferenceManager
import com.example.clase_17_prefcompartidas_viewmodel.databinding.ActivityMainBinding

//import androidx.preference.PreferenceManager        //Aumentamos una x en el android luego importamos las nuevas dependencias pero no funciona duplicado dice.

class MainActivity : AppCompatActivity() {
    lateinit var vista:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vista=ActivityMainBinding.inflate(layoutInflater)
        setContentView(vista.root)
        val manager = PreferenceManager.getDefaultSharedPreferences(this)
/*         ESTO ES PRACTICANDO´CON LLAVES PUEDE SER
        val manager = PreferenceManager.getDefaultSharedPreferences(this)       //Decaramos una variable vinculado con preference
        Log.i("message","Valor guardado en el dispositivo ${manager.getString("valor","-----")}")        //Obtenemos el valor guardado y si no hay saldrá +++**+++


        val editor = manager.edit()                 //Editamos
        editor.putString("valor","Clave_Valor")     //Guardamos la clave que qeneramos es decir guardar
        editor.commit()                             //Luego aplicamos el guardado con el commit()
        //editor.remove("valor")                      //Para remover el valor guardado
        //editor.clear()                              //Para limpiar

       //Esto es para el logo de ANDROID
        if(manager.getInt("estado",0)==1){
            startActivity(Intent(this, system::class.java))
        }
        //Haremos codigo para que solo se muestre la primera ves
        val image = manager.edit()
        image.putInt("estado",1)
        image.commit()
 */
    //HAREMOS PARA EL BOTON LOGIN
        if (manager.getInt("Login",0)==1){
            startActivity(Intent(this, system::class.java))
            finish()        //Para que no retroceda
        }
        vista.btnLogin.setOnClickListener {
            val editor = manager.edit()
            editor.putInt("Login",1)
            editor.commit()
            startActivity(Intent(this, system::class.java))
            finish()
        }
    }
}