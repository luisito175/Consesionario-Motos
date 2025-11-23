package iesvdc.segdodam.recyclerviewmotos.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import iesvdc.segdodam.recyclerviewmotos.R
import iesvdc.segdodam.recyclerviewmotos.adapters.ViewHMoto
import iesvdc.segdodam.recyclerviewmotos.databinding.ObjetoMotoBinding
import iesvdc.segdodam.recyclerviewmotos.models.Moto

class AdapterMoto(var listMoto: MutableList<Moto>,
                  var deleteOnClick:(Int) -> Unit,
                  var updateOnClick:(Int) -> Unit)
    : RecyclerView.Adapter<ViewHMoto>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHMoto {
        val binding = ObjetoMotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHMoto(binding, deleteOnClick, updateOnClick)
    }

    override fun onBindViewHolder(holder: ViewHMoto, position: Int) {
        holder.renderize(listMoto[position], position)
    }

    override fun getItemCount(): Int = listMoto.size
}
