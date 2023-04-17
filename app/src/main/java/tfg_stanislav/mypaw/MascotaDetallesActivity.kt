package tfg_stanislav.mypaw

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MascotaDetallesActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mascota_detalles)
        val spinner = findViewById<Spinner>(R.id.historial_spinner)
        spinner.setSelection(0) // Establecer el elemento predeterminado

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                if (selectedItem == "Historial de vacunas") {
                    val intent = Intent(this@MascotaDetallesActivity, VacunasActivity::class.java)
                    startActivity(intent)
                }else if (selectedItem == "Historial de análisis") {
                    val intent = Intent(this@MascotaDetallesActivity, AnalisisActivity::class.java)
                    startActivity(intent)
                }else if (selectedItem == "Historial de procedimientos") {
                    val intent = Intent(this@MascotaDetallesActivity, ProcedimientosActivity::class.java)
                    startActivity(intent)
                }else if (selectedItem == "Historial de consultas") {
                    val intent = Intent(this@MascotaDetallesActivity, ConsultasActivity::class.java)
                    startActivity(intent)
                }else if (selectedItem == "Historial de peso") {
                    val intent = Intent(this@MascotaDetallesActivity, PesoActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        val mascota = intent.getParcelableExtra<Mascota>("mascota")
        if(mascota != null) {
            val textView : TextView = findViewById(R.id.mascotaDetallesActivityTextView)
            val imageView : ImageView = findViewById(R.id.mascotaDetallesActivityImageView)
            val iconoEspecie : ImageView = findViewById(R.id.iconoEspecie)
            val especie : TextView = findViewById(R.id.especie)
            val iconoRaza : ImageView = findViewById(R.id.iconoRaza)
            val raza : TextView = findViewById(R.id.raza)
            val iconoCumpleanyos : ImageView = findViewById(R.id.iconoCumpleanyos)
            val cumpleanyos : TextView = findViewById(R.id.cumpleanyos)
            val iconoColor : ImageView = findViewById(R.id.iconoColor)
            val color : TextView = findViewById(R.id.color)
            val iconoPeso : ImageView = findViewById(R.id.iconoPeso)
            val peso : TextView = findViewById(R.id.peso)

            textView.text = mascota.nombre
            imageView.setImageResource(mascota.foto)
            iconoEspecie.setImageResource(mascota.imageEspecie)
            especie.text = mascota.especie
            iconoRaza.setImageResource(mascota.imageRaza)
            raza.text = mascota.raza
            iconoCumpleanyos.setImageResource(mascota.imageCumpleanyos)
            cumpleanyos.text = mascota.cumpleanyos
            iconoColor.setImageResource(mascota.imageColor)
            color.text = mascota.color
            iconoPeso.setImageResource(mascota.imagePeso)
            peso.text = mascota.peso


        }
    }


}