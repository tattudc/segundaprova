package com.tarcisio.segundaprova

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.RadioGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.tarcisio.segundaprova.databinding.FragmentAlteraBinding

@Suppress("UNREACHABLE_CODE")
class AlteraFragment : Fragment() {

    lateinit var binding: FragmentAlteraBinding
    lateinit var alteraFragmentViewModel: AlteraFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_altera, container, false)

        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        alteraFragmentViewModel = ViewModelProvider(this).get(AlteraFragmentViewModel::class.java);

        val args:AlteraFragmentArgs by navArgs();
        alteraFragmentViewModel.setDados(args.id);

        binding.apply{
            textNomeCafe.setText(alteraFragmentViewModel.nome);
            textPaisCafe.setText(alteraFragmentViewModel.pais);
            textSabor.setText(alteraFragmentViewModel.sabor);
            textPrecoCafe.setText(alteraFragmentViewModel.preco.toString());
            textEditGrao.setText(alteraFragmentViewModel.grao);

            if(alteraFragmentViewModel.brasilProduz == 1){
                radioButtonSim.isChecked = true;
                radioButtonNao.isChecked = false;
            }else{
                radioButtonSim.isChecked = false;
                radioButtonNao.isChecked = true;
            }
        }

        binding.radioGrupoEBrasil.setOnCheckedChangeListener { _: RadioGroup, _: Int ->
            if(binding.radioButtonSim.isChecked){
                alteraFragmentViewModel.brasilProduz = 1;
            }else if(binding.radioButtonNao.isChecked){
                alteraFragmentViewModel.brasilProduz = 0;
            }
        }

        binding.btnAlterar.setOnClickListener {
            alteraFragmentViewModel.nome = binding.textNomeCafe.text.toString();
            alteraFragmentViewModel.pais = binding.textPaisCafe.text.toString();
            alteraFragmentViewModel.sabor =  binding.textSabor.text.toString();
            alteraFragmentViewModel.preco = binding.textPrecoCafe.text.toString().toFloat();
            alteraFragmentViewModel.grao = binding.textEditGrao.text.toString();
            
            var cafe = Cafe(alteraFragmentViewModel.nome, alteraFragmentViewModel.pais, alteraFragmentViewModel.sabor, alteraFragmentViewModel.preco, alteraFragmentViewModel.grao, alteraFragmentViewModel.brasilProduz);
            cafe.id = args.id.toInt();
            alteraFragmentViewModel.AlteraDados(cafe);
            Navigation.findNavController(it).navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment());
        }

        setHasOptionsMenu(true);

        return binding.root;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.opitionsmenu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }

}