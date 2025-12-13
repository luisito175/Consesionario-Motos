package iesvdc.segdodam.recyclerviewmotos.Dialogs

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import iesvdc.segdodam.recyclerviewmotos.databinding.DialogMotoBinding
import iesvdc.segdodam.recyclerviewmotos.models.Moto

class MotoDialogFragment(private val moto : Moto? = null,
                         private val onSave: (Moto) -> Unit) : DialogFragment() {
    private var _binding: DialogMotoBinding? =null
    private val binding get() = _binding!!

    private var selectedImageUri: Uri? = null
    private val pickImageLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            selectedImageUri = it
            binding.imgPreview.setImageURI(it)
            binding.edtImagen.setText(it.toString())
        }
    }

    private val PICK_IMAGE_REQUEST = 100


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        _binding = DialogMotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            selectedImageUri = data?.data
            binding.imgPreview.setImageURI(selectedImageUri)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moto?.let{
            binding.edtMarca.setText(it.marca)
            binding.edtModelo.setText(it.modelo)
            binding.edtCaracteristicas.setText(it.caracteristicas)
            binding.edtImagen.setText(it.imagen)

        }

        binding.btnSelectImage.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }


        binding.btnAceptar.setOnClickListener {
            val imagen = selectedImageUri?.toString() ?: moto?.imagen ?: ""
            val nuevaMoto = Moto(
                marca = binding.edtMarca.text.toString(),
                modelo = binding.edtModelo.text.toString(),
                caracteristicas = binding.edtCaracteristicas.text.toString(),
                imagen = imagen
            )
            onSave(nuevaMoto)
            dismiss(
            )
        }

        binding.btnCancelar.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }







}