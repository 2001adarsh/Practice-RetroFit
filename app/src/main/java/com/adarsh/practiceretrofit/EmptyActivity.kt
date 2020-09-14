package com.adarsh.practiceretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_cs.*
import kotlinx.android.synthetic.main.item_cs.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EmptyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
        val getValue = intent.getStringExtra("Name")

        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO){
                RetroFitClient.githubApi.getUserByName(getValue)
            }
            if(response.isSuccessful){
                user_name.text = response.body()?.login
                name_.text = response.body()?.id.toString()
                Picasso.get().load(response.body()?.avatarUrl).into(image_)
            }
        }
    }
}