package com.nr.trynavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.nr.trynavigationcomponent.databinding.FragmentSecondBinding
import com.nr.trynavigationcomponent.databinding.FragmentThridBinding

class ThridFragment : Fragment() {
    private var _binding: FragmentThridBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThridBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mendapatkan data argument sesuai dengan key yang dimaksud
        val aName = ThridFragmentArgs.fromBundle(arguments as Bundle).name

        binding.tvOutputName.text = "Name: $aName"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}