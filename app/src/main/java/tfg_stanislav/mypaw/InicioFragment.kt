package tfg_stanislav.mypaw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import androidx.recyclerview.widget.LinearLayoutManager
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var mList: ArrayList<DataItem>
private lateinit var rv: RecyclerView
private lateinit var inicioAdapter: InicioAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [InicioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InicioFragment : Fragment() {
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
        return inflater.inflate(R.layout.activity_inicio, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Inicio.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InicioFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareData()
        val layoutManager = LinearLayoutManager(context)
        rv = view.findViewById(R.id.mainRecyclerView) as RecyclerView
        rv.layoutManager = layoutManager
        rv.setHasFixedSize(true)
        inicioAdapter = InicioAdapter(mList)
        rv.adapter = inicioAdapter

    }

    private fun prepareData() {
        mList = ArrayList()

        // best seller
        val bestSellerList = ArrayList<RecyclerItem>()
        bestSellerList.add(RecyclerItem(R.drawable.banner_salud, "La salud de tu mascota"))
        bestSellerList.add(RecyclerItem(R.drawable.banner_juguetes, "Que no falte la diversión"))
        bestSellerList.add(RecyclerItem(R.drawable.banner_accesorios, "Mejora tu look"))
        bestSellerList.add(RecyclerItem(R.drawable.banner_camas, "El descanso primero"))
//        bestSellerList.add(RecyclerItem(R.drawable.mobiles, "Up to 10% off"))
//        bestSellerList.add(RecyclerItem(R.drawable.watches, "Up to 40% off"))

        //clothing
        val clothingList = ArrayList<RecyclerItem>()
        clothingList.add(RecyclerItem(R.drawable.comida1, "25% de descuento"))
        clothingList.add(RecyclerItem(R.drawable.comida2, "25% de descuento"))
        clothingList.add(RecyclerItem(R.drawable.comida5, "Cordero Fresco"))
        clothingList.add(RecyclerItem(R.drawable.comida6, "Pollo de corral"))
        clothingList.add(RecyclerItem(R.drawable.comida3, "Salmón y Pavo"))
        clothingList.add(RecyclerItem(R.drawable.comida4, "Salmón Noruego"))

        mList.add(DataItem(DataItemType.BANNER, Banner(R.drawable.portada)))
        mList.add(DataItem(DataItemType.BEST_SELLER, bestSellerList))
        mList.add(DataItem(DataItemType.BANNER, Banner(R.drawable.banner_comida_perro2)))
        mList.add(DataItem(DataItemType.CLOTHING, clothingList))
        mList.add(DataItem(DataItemType.BANNER, Banner(R.drawable.banner_comida_perro3)))
        mList.add(DataItem(DataItemType.BEST_SELLER, bestSellerList.asReversed()))
        mList.add(DataItem(DataItemType.CLOTHING, clothingList.asReversed()))
        mList.add(DataItem(DataItemType.BANNER, Banner(R.drawable.banner_comida_perro)))

    }

}