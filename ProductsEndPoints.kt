package hr.ferit.petrakis.lv7

import retrofit2.Call
import retrofit2.http.GET

interface ProductsEndPoints
{
    @GET("/api/v1/products.json")
    fun getProducts(): Call<List<Products>>

}