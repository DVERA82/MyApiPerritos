package com.example.myapiperritos.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapiperritos.R
import com.example.myapiperritos.databinding.FragmentFirstBinding
import com.example.myapiperritos.viewModel.ViewModelRaza

class FirstFragment : Fragment() {

    private  lateinit var binding: FragmentFirstBinding
    private val viewModelRaza: ViewModelRaza by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter= AdapterRaza()
        binding.rvRaza.adapter= adapter

        binding.rvRaza.layoutManager= GridLayoutManager(context,1)

        //La vieja confiable
        viewModelRaza.razaLiveDataFromDB.observe(viewLifecycleOwner, androidx.lifecycle.Observer{
            it?.let{
                Log.d("LISTADO RAZA",it.toString())
                adapter.update(it)

            }
        })

        adapter.selectedItem().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it?.let{
                val bundle= Bundle()
                bundle.putString("status",it.raza)
                viewModelRaza.getfetchRazaWithCoroutines(it.raza)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
            }
        })

    }



}