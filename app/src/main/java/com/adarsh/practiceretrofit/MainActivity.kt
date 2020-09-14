package com.adarsh.practiceretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager =LinearLayoutManager(this)
        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO){
                RetroFitClient.githubApi.getUser()
            }
            if(response.isSuccessful){
                val adapter = AdapterForGit(response.body())
                recycler_view.adapter = adapter
            }
        }



        button.setOnClickListener {
            val value = editTextTextPersonName.text.toString()
//            val intent = Intent(this, EmptyActivity::class.java)
//            intent.putExtra("Name", value)
//            startActivity(intent)
            GlobalScope.launch(Dispatchers.Main) {
                val response = withContext(Dispatchers.IO){
                    RetroFitClient.githubApi.searchUser(value)
                }
                if(response.isSuccessful){
                    val adapter = AdapterForGit(response.body()?.items)
                    recycler_view.adapter = adapter
                }
            }
        }
    }
}