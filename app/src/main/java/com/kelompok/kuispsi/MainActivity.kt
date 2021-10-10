package com.kelompok.kuispsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<ContentResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvContent)
        val refresh = findViewById<Button>(R.id.refreshButton)

        refresh.setOnClickListener { view ->
            finish()
            overridePendingTransition(0, 0)
            startActivity(getIntent())
            overridePendingTransition(0, 0)
        }

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getContent().enqueue(object: Callback<ArrayList<ContentResponse>>{
            override fun onResponse(
                call: Call<ArrayList<ContentResponse>>,
                response: Response<ArrayList<ContentResponse>>
            ) {
                response.body()?.let { list.addAll(it) }
                val adapter = ContentAdapter(list)
                rv.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ContentResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}