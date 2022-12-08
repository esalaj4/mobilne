package hr.ferit.petrakis.lv7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request= ServiceBuilder.buildService(ProductsEndPoints::class.java)
        val call= request.getProducts()

        call.enqueue(object : retrofit2.Callback<List<Products>> {
            override fun onResponse(call: Call<List<Products>>, response:
            Response<List<Products>>
            ) {
                if(response.isSuccessful) {
                    findViewById<RecyclerView>(R.id.productsList).apply {
                        layoutManager =
                            LinearLayoutManager(this@MainActivity)
                        adapter =
                            ProductsAdapter(response.body()!!)
                    }
                }
            }
            override fun onFailure(call: Call<List<Products>>, t: Throwable)
            {
                Log.d("FAIL", t.message.toString())
            }
        })
    }
}