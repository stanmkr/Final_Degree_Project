package tfg_stanislav.mypaw

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MascotaDetallesActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mascota_detalles)

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