package tfg_stanislav.mypaw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var recyclerView: RecyclerView
private lateinit var listaClinicas: ArrayList<Clinica>
private lateinit var clinicaAdapter: ClinicaAdapter
lateinit var imageId : Array<Int>
lateinit var titulo : Array<String>
lateinit var detallesClinica : Array<String>

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
    }

    private fun dataInit() {
        listaClinicas = arrayListOf<Clinica>()

        imageId = arrayOf(
            R.drawable.clinica,
            R.drawable.clinica,
            R.drawable.clinica,
            R.drawable.clinica,
            R.drawable.clinica,
            R.drawable.clinica,
        )
        titulo = arrayOf(
            "Clinica Torrevieja",
            "Clinica Orihuela Costa",
            "Clinica Alicante",
            "Clinica Elche",
            "Clinica Valencia",
            "Clinica Murcia",
        )

        detallesClinica = arrayOf(
            "Detalles de la clinica de Torrevieja",
            "Detalles de la clinica de Orihuela Costa",
            "Detalles de la clinica de Alicante",
            "Detalles de la clinica de Elche",
            "Detalles de la clinica de Valencia",
            "Detalles de la clinica de Murcia",


        )

        for (i in imageId.indices) {
            val detallesClinica = Clinica(imageId[i], titulo[i])
            listaClinicas.add(detallesClinica)

        }

    }


}