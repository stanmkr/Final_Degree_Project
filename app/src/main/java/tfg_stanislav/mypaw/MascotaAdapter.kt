package tfg_stanislav.mypaw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MascotaAdapter(private val listaMascotas: ArrayList<Mascota>) :
    RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    var onItemClick: ((Mascota) -> Unit)? = null

    class MascotaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.mascotaImageView)
        val textView: TextView = itemView.findViewById(R.id.mascotaTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_animal, parent, false)
        return MascotaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaMascotas.size
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = listaMascotas[position]
        holder.imageView.setImageResource(mascota.foto)
        holder.textView.text = mascota.nombre


        holder.itemView.setOnClickListener {
            onItemClick?.invoke(mascota)
        }

    }

}