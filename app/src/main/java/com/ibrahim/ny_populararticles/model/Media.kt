package com.ibrahim.ny_populararticles.model

import com.squareup.moshi.Json

data class Media(
    val type : String ?= "",
    val subtype : String ?= "",
    val caption : String ?= "",
    val copyright : String ?= "",
    val approved_for_syndication : Int ?= 0,
    @Json(name = "media-metadata")
    val metadata : List<MetaData> = ArrayList()
)

data class MetaData(
    val url : String ?= "",
    val format : String ?= "",
    val height : Int ?= 0,
    val width : Int ?= 0,
)
