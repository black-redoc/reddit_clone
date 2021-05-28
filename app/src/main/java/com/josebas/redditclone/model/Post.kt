package com.josebas.redditclone.model

data class Post(
    val author: String,
    val subreddit: String,
    val title: String,
    val thumbnail: String,
    val url: String?,
    val is_video: Boolean,
    val total_awards_received: Int,
    val description: String?,
    val ups: Int?,
    val num_comments: Int,
    val secure_media: SecureMedia
)
