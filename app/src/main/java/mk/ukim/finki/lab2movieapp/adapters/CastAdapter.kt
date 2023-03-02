package mk.ukim.finki.lab2movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.lab2movieapp.R
import mk.ukim.finki.lab2movieapp.domain.movie.model.CastDetails

class CastAdapter(private val cast:ArrayList<CastDetails> = ArrayList<CastDetails>()): RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    class CastViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private var castName: TextView = view.findViewById(R.id.cast_name)

        fun bind(cast: CastDetails){
            castName.text = cast.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_cast_details, parent, false)
        return CastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cast.size
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(cast[position])
    }

}