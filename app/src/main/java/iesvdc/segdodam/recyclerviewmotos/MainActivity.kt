package iesvdc.segdodam.recyclerviewmotos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import iesvdc.segdodam.recyclerviewmotos.Controller.Controller
import iesvdc.segdodam.recyclerviewmotos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var controller: Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        initRecyclerView()
        controller = Controller(this)
        controller.setAdapter()
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}
