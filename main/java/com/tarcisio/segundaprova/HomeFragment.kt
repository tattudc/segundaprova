package com.tarcisio.segundaprova

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.tarcisio.segundaprova.databinding.FragmentHomeBinding

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding;
    lateinit var homeFragmentViewModel: HomeFragmentViewModel;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        homeFragmentViewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java);

        val cafeAdapter = CafeAdapter();
        val layout = LinearLayoutManager(parentFragment?.requireContext(), LinearLayoutManager.VERTICAL, false);

        binding.recyclerView.adapter = cafeAdapter;
        binding.recyclerView.layoutManager = layout;

        setHasOptionsMenu(true);

        homeFragmentViewModel.cafe?.observe(viewLifecycleOwner) {
            cafeAdapter.listaCafe = it;
            cafeAdapter.notifyDataSetChanged();
        };

        binding.recyclerView.addOnItemTouchListener(RecyclerView(requireContext(),  binding.recyclerView,
                object : RecyclerView.OnItemClickListener{
                    override fun onItemClick(view: View, position: Int) {
                        Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(cafeAdapter.listaCafe[position].id.toLong()));
                    }

                    override fun onItemLongClick(view: View, position: Int) {
                        Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(cafeAdapter.listaCafe[position].id.toLong()));
                    }
                }))

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