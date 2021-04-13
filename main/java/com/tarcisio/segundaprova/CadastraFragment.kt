package com.tarcisio.segundaprova

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import com.tarcisio.segundaprova.CadastraFragmentViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.tarcisio.segundaprova.databinding.FragmentCadastraBinding

class CadastraFragment : Fragment() {
    lateinit var binding: FragmentCadastraBinding;
    lateinit var cadastraFragmentViewModel: CadastraFragmentViewModel;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false);
        cadastraFragmentViewModel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java);


         binding.radioGrupoEBrasil.setOnCheckedChangeListener { _: RadioGroup, _: Int ->
             if (binding.radioButtonSim.isChecked) {
                 cadastraFragmentViewModel.brasilProduz = 1;
             } else if (binding.radioButtonNao.isChecked) {
                 cadastraFragmentViewModel.brasilProduz = 0;
             }
         }


        binding.btnCadastrar.setOnClickListener {
            cadastraFragmentViewModel.nome = binding.textNomeCafe.text.toString();
            cadastraFragmentViewModel.pais = binding.textPaisCafe.text.toString();
            cadastraFragmentViewModel.sabor = binding.textSabor.text.toString();
            cadastraFragmentViewModel.preco =  binding.textPrecoCafe.text.toString().toFloat();
            cadastraFragmentViewModel.grao = binding.textEditGrao.text.toString();
            cadastraFragmentViewModel.cadastraDados(Cafe(cadastraFragmentViewModel.nome, cadastraFragmentViewModel.pais, cadastraFragmentViewModel.sabor, cadastraFragmentViewModel.preco, cadastraFragmentViewModel.grao, cadastraFragmentViewModel.brasilProduz));
            Navigation.findNavController(it).navigate(CadastraFragmentDirections.actionCadastraFragmentToHomeFragment());
        }

        setHasOptionsMenu(true);

        return binding.root;

     }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.cadastramenu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}
