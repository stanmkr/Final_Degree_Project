package tfg_stanislav.mypaw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClinicaAdapter(private val clinicaList: ArrayList<Clinica>) :
    RecyclerView.Adapter<ClinicaAdapter.ClinicaViewHolder>() {

    var onItemClick: ((Clinica) -> Unit)? = null

    class ClinicaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.clinicaImageView)
        val TextView: TextView = itemView.findViewById(R.id.clinicaTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_clinic, parent, false)
        return ClinicaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return clinicaList.size
    }

    override fun onBindViewHolder(holder: ClinicaViewHolder, position: Int) {
        val clinica = clinicaList[position]
        holder.imageView.setImageResource(clinica.image)
        holder.TextView.text = clinica.name


        holder.itemView.setOnClickListener {
            onItemClick?.invoke(clinica)
        }

    }

}