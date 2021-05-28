package com.josebas.redditclone.model

data class Data(
    val modhash: String,
    val dist: Int,
    val children: List<Reddit>,
    val after: String,
    val before: String?
)
