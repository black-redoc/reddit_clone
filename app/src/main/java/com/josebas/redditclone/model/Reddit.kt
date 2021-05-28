package com.josebas.redditclone.model

import com.google.gson.annotations.SerializedName

data class Reddit(
    val kind: String,
    @SerializedName("data") val post: Post
)
