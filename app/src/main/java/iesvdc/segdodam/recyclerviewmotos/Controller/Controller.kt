package iesvdc.segdodam.recyclerviewmotos.Controller

import android.content.Context
import android.widget.Adapter
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Carousel
import iesvdc.segdodam.recyclerviewmotos.Adapter.AdapterMoto
import iesvdc.segdodam.recyclerviewmotos.Dialogs.MotoDialogFragment
import iesvdc.segdodam.recyclerviewmotos.MainActivity
import iesvdc.segdodam.recyclerviewmotos.models.Moto

class Controller(private val context: Context) {

    lateinit var listMotos: MutableList<Moto>
    private lateinit var adapter: AdapterMoto

    init {
        initMotos()
    }

    private fun initMotos() {
        listMotos = DaoMoto.myDao.getAllMotos().toMutableList()
    }

    fun loggout() {
        Toast.makeText(context, "He mostrado los datos en pantalla", Toast.LENGTH_LONG).show()
        listMotos.forEach {println(it)}

    }

    fun delMoto(pos: Int) {
        Toast.makeText(context, "Borrar moto: ${listMotos[pos].modelo}", Toast.LENGTH_SHORT).show()
        listMotos.removeAt(pos)
        adapter.notifyItemRemoved(pos)
        adapter.notifyItemRangeChanged(pos, listMotos.size)
    }

    fun updateMoto(pos: Int) {
        val activity = context as MainActivity
        val moto = listMotos[pos]

        val dialog = MotoDialogFragment(moto) {motoActualizada ->
            listMotos[pos] = motoActualizada
            adapter.notifyItemChanged(pos)
        }
        dialog.show(activity.supportFragmentManager, "EDIT_MOTO")
    }

    fun addMoto() {
        val activity = context as MainActivity

        // Creamos el dialog sin moto existente
        val dialog = MotoDialogFragment(null) { nuevaMoto ->
            listMotos.add(nuevaMoto)
            adapter.notifyItemInserted(listMotos.size - 1)
        }

        dialog.show(activity.supportFragmentManager, "ADD_MOTO")
    }


    fun setAdapter(){
        val myActivity = context as MainActivity
        adapter = AdapterMoto(listMotos, ::delMoto, ::updateMoto)
        myActivity.binding.myRecyclerView.adapter = adapter
    }
}