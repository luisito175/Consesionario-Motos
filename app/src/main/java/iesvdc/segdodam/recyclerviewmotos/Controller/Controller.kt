package iesvdc.segdodam.recyclerviewmotos.Controller

import android.content.Context
import android.widget.Adapter
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Carousel
import iesvdc.segdodam.recyclerviewmotos.Adapter.AdapterMoto
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
        Toast.makeText(context, "Actualizar moto: ${listMotos[pos].modelo}", Toast.LENGTH_SHORT).show()
    }

    fun setAdapter(){
        val myActivity = context as MainActivity
        adapter = AdapterMoto(listMotos, ::delMoto, ::updateMoto)
        myActivity.binding.myRecyclerView.adapter = adapter
    }
}
