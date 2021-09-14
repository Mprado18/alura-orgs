package com.example.alura_orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.alura_orgs.databinding.FormDialogBinding
import com.example.alura_orgs.extensions.uploadImage

class FormDialog(private val context: Context) {

    fun showDialog(
        urlDefault: String? = null,
        whenRenderImage: (image: String) -> Unit
    ) {
        val binding = FormDialogBinding.inflate(LayoutInflater.from(context))

        with(binding) {
            urlDefault?.let {
                formDialogImage.uploadImage(it)
                inputUrl.setText(it)
            }

            buttonUpload.setOnClickListener {
                val url = inputUrl.text.toString()
                formDialogImage.uploadImage(url)
            }

            AlertDialog.Builder(context)
                .setView(binding.formDialogRoot)
                .setPositiveButton("Confirmar") { _, _ ->
                    val url = inputUrl.text.toString()
                    whenRenderImage(url)
                }
                .setNegativeButton("Cancelar") { _, _ ->

                }
                .show()
        }
    }

}