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
private lateinit var listaClinicas: ArrayList<Clinica>
private lateinit var clinicaAdapter: ClinicaAdapter
lateinit var imageId: Array<Int>
lateinit var imageTlf: Array<Int>
lateinit var imageEmail: Array<Int>
lateinit var imageDireccion: Array<Int>
lateinit var imageHorario: Array<Int>
lateinit var titulo: Array<String>
lateinit var telefono: Array<String>
lateinit var email: Array<String>
lateinit var direccion: Array<String>
lateinit var horario: Array<String>

//lateinit var detallesClinica: Array<String>

/**
 * A simple [Fragment] subclass.
 * Use the [ClinicasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClinicasFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_clinicas, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Clinicas.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ClinicasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerViewClinicas)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        clinicaAdapter = ClinicaAdapter(listaClinicas)
        recyclerView.adapter = clinicaAdapter

        clinicaAdapter.onItemClick = {
            val intent = Intent(context, ClinicaDetallesActivity::class.java)
            intent.putExtra("clinica", it)
            startActivity(intent)
        }
    }

    private fun dataInit() {
        listaClinicas = arrayListOf<Clinica>()

        imageId = arrayOf(
            R.drawable.clinica,
            R.drawable.clinica,
            R.drawable.clinica,
            R.drawable.clinica,
            R.drawable.clinica,
            R.drawable.clinica
        )
        titulo = arrayOf(
            "Clínica Torrevieja",
            "Clínica Orihuela Costa",
            "Clínica Alicante",
            "Clínica Elche",
            "Clínica Valencia",
            "Clínica Murcia"
        )
        imageTlf = arrayOf(
            R.drawable.baseline_local_phone_24,
            R.drawable.baseline_local_phone_24,
            R.drawable.baseline_local_phone_24,
            R.drawable.baseline_local_phone_24,
            R.drawable.baseline_local_phone_24,
            R.drawable.baseline_local_phone_24
        )
        imageEmail = arrayOf(
            R.drawable.baseline_email_24,
            R.drawable.baseline_email_24,
            R.drawable.baseline_email_24,
            R.drawable.baseline_email_24,
            R.drawable.baseline_email_24,
            R.drawable.baseline_email_24
        )

        imageDireccion = arrayOf(
            R.drawable.baseline_address_24,
            R.drawable.baseline_address_24,
            R.drawable.baseline_address_24,
            R.drawable.baseline_address_24,
            R.drawable.baseline_address_24,
            R.drawable.baseline_address_24
        )

        imageHorario = arrayOf(
            R.drawable.baseline_clock_24,
            R.drawable.baseline_clock_24,
            R.drawable.baseline_clock_24,
            R.drawable.baseline_clock_24,
            R.drawable.baseline_clock_24,
            R.drawable.baseline_clock_24
        )

        telefono = arrayOf(
            "666 777 888",
            "333 777 888",
            "444 777 888",
            "111 777 888",
            "555 777 888",
            "222 777 888"
        )
        email = arrayOf(
            "torrevieja@mypaw.es",
            "orihuelacosta@mypaw.es",
            "alicante@mypaw.es",
            "elche@mypaw.es",
            "valencia@mypaw.es",
            "murcia@mypaw.es",
        )

        direccion = arrayOf(
            "c/ Apolo 3, Torrevieja 03184",
            "c/ Marte 98, Orihuela Costa 03189",
            "c/ Luna 33, Alicante 03010",
            "c/ Bazan 4, Elche 03201",
            "c/ La Sal 77, Valencia 46001",
            "c/ Sol 12, Murcia 30001"
        )

        horario = arrayOf(
            "L-V 9 a 20:30\nSábado 9 a 14:00",
            "L-V 9 a 20:30\nSábado 9 a 14:00",
            "L-V 9 a 20:30\nSábado 9 a 14:00",
            "L-V 9 a 20:30\nSábado 9 a 14:00",
            "L-V 9 a 20:30\nSábado 9 a 14:00",
            "L-V 9 a 20:30\nSábado 9 a 14:00",
        )



//        detallesClinica = arrayOf(
//            "Detalles de la clinica de Torrevieja",
//            "Detalles de la clinica de Orihuela Costa",
//            "Detalles de la clinica de Alicante",
//            "Detalles de la clinica de Elche",
//            "Detalles de la clinica de Valencia",
//            "Detalles de la clinica de Murcia"
//            )

        for (i in imageId.indices) {
            val detallesClinica = Clinica(imageId[i], titulo[i], imageTlf[i], telefono[i],imageEmail[i], email[i],
                imageDireccion[i], direccion[i], imageHorario[i], horario[i])
            listaClinicas.add(detallesClinica)

        }


    }


}