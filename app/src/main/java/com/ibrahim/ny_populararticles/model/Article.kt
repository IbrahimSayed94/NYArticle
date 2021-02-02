package com.ibrahim.ny_populararticles.model

data class Article(
    val url : String ?= "",
    val adx_keywords : String ?= "",
    val subsection : String ?= "",
    val email_count : Int ?= 0,
    val count_type : String ?= "",
    val column : String ?= "",
    val eta_id : Int ?= 0,
    val section : String ?= "",
    val id : Long ?= 0L,
    val asset_id : Long ?= 0L,
    val nytdsection : String ?= "",
    val byline : String ?= "",
    val type : String ?= "",
    val title : String ?= "",
    val abstract : String ?= "",
    val published_date : String ?= "",
    val source : String ?= "",
    val updated : String ?= "",
    val des_facet : List<String> ?= ArrayList(),
    val org_facet : List<String> ?= ArrayList(),
    val per_facet : List<String> ?= ArrayList(),
    val geo_facet : List<String> ?= ArrayList(),
    val media : List<Media> ?= ArrayList(),
    val uri : String ?= ""
)