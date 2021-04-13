package com.tarcisio.segundaprova

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.content.DialogInterface

class DialogFragment: DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Cadastro\n______________________________________")
            builder.setMessage("Realize o cadastro seguindo essas instruções:\n" +
                    "\nDefina o nome do café, país de origem, sabor, preço \n" +
                    "\ne o tamanho do grão. E por último defina se é produzido\n" +
                    "\nno Brasil ou não. Ao final clique em cadastrar café!")
                    .setPositiveButton("Entendi",
                            DialogInterface.OnClickListener { dialog, id -> })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}