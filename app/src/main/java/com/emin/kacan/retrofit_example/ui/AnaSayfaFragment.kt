package com.emin.kacan.retrofit_example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.emin.kacan.retrofit_example.R
import com.emin.kacan.retrofit_example.adapter.ProductAdapter
import com.emin.kacan.retrofit_example.data.apiInterface
import com.emin.kacan.retrofit_example.databinding.FragmentAnaSayfaBinding
import com.emin.kacan.retrofit_example.model.UrunItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnaSayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var adapter: ProductAdapter
    var BASE_URL = "https://fakestoreapi.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnaSayfaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        getAllData()
    }

    private fun getAllData(){
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiInterface::class.java)

        var retroData =retrofit.getData()

        retroData.enqueue(object : Callback<List<UrunItem>>{
            override fun onResponse(
                call: Call<List<UrunItem>>,
                response: Response<List<UrunItem>>
            ) {
                var data = response.body()
                adapter = ProductAdapter(requireContext(),data!!)
                binding.rv.adapter = adapter
            }

            override fun onFailure(call: Call<List<UrunItem>>, t: Throwable) {}

        })
    }

}