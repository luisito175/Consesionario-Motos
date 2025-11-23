package iesvdc.segdodam.recyclerviewmotos.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import iesvdc.segdodam.recyclerviewmotos.databinding.ObjetoMotoBinding
import iesvdc.segdodam.recyclerviewmotos.models.Moto

class ViewHMoto(
    private val binding: ObjetoMotoBinding,
    private val deleteOnClick: (Int) -> Unit,
    private val updateOnClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun renderize(moto: Moto, position: Int) {
        binding.txtMarca.text = moto.marca
        binding.txtModelo.text = moto.modelo
        binding.txtCaracteristicas.text = moto.caracteristicas

        Glide.with(binding.root.context)
            .load(moto.imagen)
            .into(binding.imgFotoMoto)

        binding.btnEdit.setOnClickListener { updateOnClick(position) }
        binding.btnDelete.setOnClickListener { deleteOnClick(position) }
    }
}
