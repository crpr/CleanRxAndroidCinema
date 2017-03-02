package com.crpr.androidcinema.data.api.models

/**
 * Created by claudioribeiro on 11/07/16.
 */
data class ApiMovie (val adult: Boolean = false,
                     val backdrop_path: String? = null,
                     val genres: List<Int>? = null,
                     val id: Int = 0,
                     val original_language: String? = null,
                     val original_title: String? = null,
                     val overview: String? = null,
                     val release_date: String? = null,
                     val poster_path: String? = null,
                     val popularity: Double = 0.toDouble(),
                     val title: String? = null,
                     val video: Boolean = false,
                     val vote_average: Double = 0.toDouble(),
                     val vote_count: Int = 0)
