package com.example.myapiperritos.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapiperritos.databinding.FragmentSecondBinding
import com.example.myapiperritos.viewModel.ViewModelRaza

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding : FragmentSecondBinding
    private val viewModel : ViewModelRaza by activityViewModels()
    var idImage: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idImage= it.getString("status","")
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter = AdapterImage()
        binding.rvImage.adapter= adapter
        binding.rvImage.layoutManager= GridLayoutManager(context,1)


        viewModel.getRazaBD(idImage).observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it?.let {
                Log.d("LISTADO IMAGE",it.toString())
                adapter.update(it)

            }
        })
        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it.favority) {
                    it.favority = false
                    viewModel.updateFavorityImages(it)
                    Toast.makeText(context, "ya no es favorito", Toast.LENGTH_LONG).show()
                } else {
                    it.favority = true
                    viewModel.updateFavorityImages(it)
                    Toast.makeText(context, "añadido a fav", Toast.LENGTH_LONG).show()
                }


            }
        })
    }

}



