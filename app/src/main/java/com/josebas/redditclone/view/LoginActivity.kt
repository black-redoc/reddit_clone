package com.josebas.redditclone.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.josebas.redditclone.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root

        binding.loginButton.setOnClickListener {
            val postsActivity = Intent(this, PostsActivity::class.java)
            startActivity(postsActivity)
        }

        setContentView(view)
    }
}