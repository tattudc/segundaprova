package com.tarcisio.segundaprova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.tarcisio.segundaprova.databinding.FragmentAlteraBinding

class AlteraFragment : Fragment() {

    lateinit var binding: FragmentAlteraBinding
    lateinit var alteraFragmentViewModel: AlteraFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_altera, container, false)

        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)

    }

}