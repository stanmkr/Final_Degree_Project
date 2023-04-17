package tfg_stanislav.mypaw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import tfg_stanislav.mypaw.databinding.ActivityMainBinding

class ClinicaDetallesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clinica_detalles)


        val clinica = intent.getParcelableExtra<Clinica>("clinica")
        if(clinica != null) {
            val textView : TextView = findViewById(R.id.clinicaDetallesActivityTextView)
            val imageView : ImageView = findViewById(R.id.clinicaDetallesActivityImageView)
            val iconoTelefono : ImageView = findViewById(R.id.iconoTlf)
            val telefono : TextView = findViewById(R.id.telefono)
            val iconoEmail : ImageView = findViewById(R.id.iconoEmail)
            val email : TextView = findViewById(R.id.email)
            val iconoDireccion : ImageView = findViewById(R.id.iconoDireccion)
            val direccion : TextView = findViewById(R.id.direccion)
            val iconoHorario : ImageView = findViewById(R.id.iconoHorario)
            val horario : TextView = findViewById(R.id.horario)

            textView.text = clinica.name
            imageView.setImageResource(clinica.image)
            iconoTelefono.setImageResource(clinica.imageTlf)
            telefono.text = clinica.telefono
            iconoEmail.setImageResource(clinica.imageEmail)
            email.text = clinica.email
            iconoDireccion.setImageResource(clinica.imageDir)
            direccion.text = clinica.direccion
            iconoHorario.setImageResource(clinica.imageHora)
            horario.text = clinica.horario
        }
    }

}