package com.nr.trynavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.nr.trynavigationcomponent.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mendapatkan data argument sesuai dengan key yang dimaksud
        val aName = arguments?.getString(FirstFragment.EXTRA_NAME)

        binding.tvName.text = "Your Name: $aName"

        binding.btnThirdFragment.setOnClickListener { view ->
            if (binding.etName.text.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Kolom Nama masih kosong", Toast.LENGTH_SHORT).show()
            } else {
                val actionToFragmentKetiga =
                    SecondFragmentDirections.actionSecondFragmentToThridFragment()
                actionToFragmentKetiga.name = binding.etName.text.toString()
                view.findNavController().navigate(actionToFragmentKetiga)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}