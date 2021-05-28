package com.josebas.redditclone.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.josebas.redditclone.databinding.ActivityPostsBinding
import com.josebas.redditclone.adapters.PostsAdapter
import com.josebas.redditclone.service.RedditService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView(binding.postsRv)
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val redditService = RedditService()

        GlobalScope.launch(Dispatchers.Main) {
            with(redditService.getTopRedditAsync().await()) {
                val posts = data.children.map { reddit -> reddit.post }
                val adapter = PostsAdapter(posts)
                recyclerView.adapter = adapter
            }
        }
    }
}