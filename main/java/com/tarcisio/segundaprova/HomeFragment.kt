package com.tarcisio.segundaprova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
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




    }

}