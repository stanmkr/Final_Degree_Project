package tfg_stanislav.mypaw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ClinicaDetallesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinica_detalles)

        val clinica = intent.getParcelableExtra<Clinica>("clinica")
        if(clinica != null) {
            val textView : TextView = findViewById(R.id.clinicaDetallesActivityTextView)
            val imageView : ImageView = findViewById(R.id.clinicaDetallesActivityImageView)

            textView.text = clinica.name
            imageView.setImageResource(clinica.image)
        }
    }
}