package com.emin.kacan.retrofit_example.model

import java.io.Serializable

data class UrunItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
) :Serializable