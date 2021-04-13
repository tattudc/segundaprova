package com.tarcisio.segundaprova

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.tarcisio.segundaprova.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {
    lateinit var binding: FragmentDetalhesBinding;
    lateinit var detalhesFragmentViewModel: DetalhesFragmentViewModel;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false);
        detalhesFragmentViewModel = ViewModelProvider(this).get(DetalhesFragmentViewModel::class.java);

        val args:DetalhesFragmentArgs by navArgs();
        detalhesFragmentViewModel.setDados(args.id);

        binding.apply{
            textNome.text = detalhesFragmentViewModel.nome;
            textPais.text = detalhesFragmentViewModel.pais;
            textSaborResult.text = detalhesFragmentViewModel.sabor;
            textPreco.text = detalhesFragmentViewModel.preco.toString();
            textTamanho.text = detalhesFragmentViewModel.grao;
            if(detalhesFragmentViewModel.brasilProduz == 1){
                textSimeNao.text = "Sim";
            }else{
                textSimeNao.text = "Não"
            }

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