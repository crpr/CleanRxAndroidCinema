package com.crpr.androidcinema.domain.discover

import java.io.Serializable

/**
 * Created by claudioribeiro on 12/07/16.
 */
class ListMovieModel private constructor() : Serializable {

    var id: Int = 0
        private set
    var imagePath: String? = null
        private set
    var popularity: Double = 0.toDouble()
        private set
    var title: String? = null
        private set
    var voteAverage: Double = 0.toDouble()
        private set

    interface ITitle {
        fun title(title: String): IImagePath
    }

    interface IImagePath {
        fun imagePath(url: String): IPopularity
    }

    interface IPopularity {
        fun popularity(popularity: Double): IVoteAverage
    }

    interface IVoteAverage {
        fun votesAvg(votes: Double): IBuild
    }

    interface IBuild {
        fun build(): ListMovieModel
    }

    private class Builder(id: Int) : ITitle, IImagePath, IPopularity, IVoteAverage, IBuild {

        private val instance = ListMovieModel()

        init {
            instance.id = id
        }

        override fun build(): ListMovieModel {
            return instance
        }

        override fun popularity(popularity: Double): IVoteAverage {
            instance.popularity = popularity
            return this
        }

        override fun imagePath(url: String): IPopularity {
            instance.imagePath = url
            return this
        }

        override fun title(title: String): IImagePath {
            instance.title = title
            return this
        }

        override fun votesAvg(votes: Double): IBuild {
            instance.voteAverage = votes
            return this
        }
    }

    companion object {

        fun id(id: Int): ITitle {
            return ListMovieModel.Builder(id)
        }
    }
}
