package tfg_stanislav.mypaw

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var recyclerView: RecyclerView
private lateinit var listaMascotas: ArrayList<Mascota>
private lateinit var mascotaAdapter: MascotaAdapter

lateinit var fotoId: Array<Int>
lateinit var tituloMascota: Array<String>
lateinit var imageEspecie: Array<Int>
lateinit var especie: Array<String>
lateinit var imageRaza: Array<Int>
lateinit var raza: Array<String>
lateinit var imageColor: Array<Int>
lateinit var color: Array<String>
lateinit var imagePeso: Array<Int>
lateinit var peso: Array<String>
lateinit var imageCumpleanyos: Array<Int>
lateinit var cumpleanyos: Array<String>

/**
 * A simple [Fragment] subclass.
 * Use the [MascotasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MascotasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mascotas, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Cuenta.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MascotasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepararMascota()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerViewMascotas)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        mascotaAdapter = MascotaAdapter(listaMascotas)
        recyclerView.adapter = mascotaAdapter

        mascotaAdapter.onItemClick = {
            val intent = Intent(context, MascotaDetallesActivity::class.java)
            intent.putExtra("mascota", it)
            startActivity(intent)
        }
    }

    private fun prepararMascota() {
        listaMascotas = arrayListOf()

        fotoId = arrayOf(
            R.drawable.doberman,
            R.drawable.chihuahua,
            R.drawable.pastor_aleman,
            R.drawable.gato_persa,
            R.drawable.gato_bengala,
            R.drawable.cacatua
        )

        raza = arrayOf(
            "Raza: Doberman",
            "Raza: Chihuahua",
            "Raza: Pastor Alemán",
            "Raza: Persa",
            "Raza: Bengala",
            "Raza: Cacatúa"
        )
        tituloMascota = arrayOf(
            "Odín",
            "Zeus",
            "Kairo",
            "Felix",
            "Luigi",
            "Otto"
        )
        imageColor = arrayOf(
            R.drawable.baseline_color_lens_24,
            R.drawable.baseline_color_lens_24,
            R.drawable.baseline_color_lens_24,
            R.drawable.baseline_color_lens_24,
            R.drawable.baseline_color_lens_24,
            R.drawable.baseline_color_lens_24
        )

        imagePeso = arrayOf(
            R.drawable.baseline_monitor_weight_24,
            R.drawable.baseline_monitor_weight_24,
            R.drawable.baseline_monitor_weight_24,
            R.drawable.baseline_monitor_weight_24,
            R.drawable.baseline_monitor_weight_24,
            R.drawable.baseline_monitor_weight_24
        )

        imageCumpleanyos = arrayOf(
            R.drawable.baseline_cake_24,
            R.drawable.baseline_cake_24,
            R.drawable.baseline_cake_24,
            R.drawable.baseline_cake_24,
            R.drawable.baseline_cake_24,
            R.drawable.baseline_cake_24
        )

        imageEspecie = arrayOf(
            R.drawable.especie,
            R.drawable.especie,
            R.drawable.especie,
            R.drawable.especie,
            R.drawable.especie,
            R.drawable.especie
        )

        imageRaza = arrayOf(
            R.drawable.baseline_pets_24,
            R.drawable.baseline_pets_24,
            R.drawable.baseline_pets_24,
            R.drawable.baseline_pets_24,
            R.drawable.baseline_pets_24,
            R.drawable.baseline_pets_24
        )

        color = arrayOf(
            "Color: Marrón y Negro",
            "Color: Blanco y negro",
            "Color: Marrón",
            "Color: Marron y blanco",
            "Color: Marrón con rayas negras",
            "Color: Gris y amarillo"
        )

        peso = arrayOf(
            "Peso: 15 kg",
            "Peso: 25 kg",
            "Peso: 35 kg",
            "Peso: 6 kg",
            "Peso: 4.5 kg",
            "Peso: 1 kg"
        )
        cumpleanyos = arrayOf(
            "Fecha de nacimiento: 17/04/2015",
            "Fecha de nacimiento: 1/02/2018",
            "Fecha de nacimiento: 22/05/2020",
            "Fecha de nacimiento: 17/11/2022",
            "Fecha de nacimiento: 23/09/2018",
            "Fecha de nacimiento: 23/09/2020"

        )

        especie = arrayOf(
            "Especie: Perro",
            "Especie: Perro",
            "Especie: Perro",
            "Especie: Gato",
            "Especie: Gato",
            "Especie: Ave"

        )

        for (i in fotoId.indices) {
            val detallesMascota = Mascota(
                fotoId[i], tituloMascota[i], imageEspecie[i], especie[i], imageRaza[i], raza[i],
                imageCumpleanyos[i], cumpleanyos[i], imageColor[i], color[i], imagePeso[i], peso[i]
            )
            listaMascotas.add(detallesMascota)

        }

    }


}