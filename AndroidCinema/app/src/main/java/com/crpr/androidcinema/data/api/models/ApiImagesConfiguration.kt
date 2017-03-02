package com.crpr.androidcinema.data.api.models

import com.crpr.androidcinema.data.api.models.enums.Size

/**
 * Created by claudioribeiro on 02/03/2017.
 */

data class ApiImagesConfiguration(val base_url: String? = null,
                                  val secure_base_url: String? = null,
                                  val backdrop_sizes: List<Size>? = null,
                                  val logo_sizes: List<Size>? = null,
                                  val poster_sizes: List<Size>? = null,
                                  val profile_sizes: List<Size>? = null,
                                  val still_sizes: List<Size>? = null)
