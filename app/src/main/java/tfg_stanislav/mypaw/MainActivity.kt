package tfg_stanislav.mypaw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import tfg_stanislav.mypaw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var listaClinicas: ArrayList<Clinica>
    private lateinit var clinicaAdapter: ClinicaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        replaceFragment(InicioFragment())



        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){

                R.id.home -> replaceFragment(InicioFragment())
                R.id.pets -> replaceFragment(MascotasFragment())
                R.id.clinics -> replaceFragment(ClinicasFragment())
                R.id.settings -> replaceFragment(AjustesFragment())

                else ->{



                }

            }
//            recyclerView = findViewById(R.id.recyclerViewClinicas)
//            recyclerView.setHasFixedSize(true)
//            recyclerView.layoutManager = LinearLayoutManager(this)
//
//            listaClinicas = ArrayList()
//
//            listaClinicas.add(Clinica(R.drawable.clinica, "Clínica Torrevieja"))
//            listaClinicas.add(Clinica(R.drawable.clinica, "Clínica Alicante"))
//            listaClinicas.add(Clinica(R.drawable.clinica, "Clínica Orihuela Costa"))
//            listaClinicas.add(Clinica(R.drawable.clinica, "Clínica Elche"))
//            listaClinicas.add(Clinica(R.drawable.clinica, "Clínica Valencia"))
//
//            clinicaAdapter = ClinicaAdapter(listaClinicas)
//            recyclerView.adapter = clinicaAdapter
            true

        }


    }


    private fun replaceFragment(fragment : Fragment){


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}