package com.emin.kacan.retrofit_example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.emin.kacan.retrofit_example.R
import com.emin.kacan.retrofit_example.databinding.FragmentDetayBinding

class DetayFragment : Fragment() {
    private lateinit var binding : FragmentDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetayBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle :DetayFragmentArgs by navArgs()
        val gelenUrun = bundle.urun
        val gelenBaslik = gelenUrun.title
        val gelenAciklama = gelenUrun.description
        val gelenKategori = gelenUrun.category
        val gelenFiyat = gelenUrun.price.toString()
        val gelenResim = gelenUrun.image

        binding.DetayTxtTitle.setText(gelenBaslik)
        binding.detayTxtAciklama.setText(gelenAciklama)
        binding.detayTxtKategori.setText(gelenKategori)
        binding.detayTxtFiyat.setText(gelenFiyat)
        Glide.with(requireContext()).load(gelenResim).into(binding.imageView2)


    }

}