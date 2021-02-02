package com.ibrahim.ny_populararticles.model

data class ResultResponse(
    val status : String ?= "",
    val copyright : String ?= "",
    val num_results : Int ?= 0,
    val results : List<Article> ?= ArrayList()
)