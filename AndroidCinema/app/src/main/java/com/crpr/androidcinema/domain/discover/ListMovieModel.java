package com.crpr.androidcinema.domain.discover;

import java.io.Serializable;

/**
 * Created by claudioribeiro on 12/07/16.
 */
public class ListMovieModel implements Serializable {

    private int id;
    private String image_path;
    private double popularity;
    private String title;
    private double vote_average;

    private ListMovieModel(){}

    public int getId() {
        return id;
    }

    public String getImagePath() {
        return image_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getTitle() {
        return title;
    }

    public double getVoteAverage() {
        return vote_average;
    }

    public interface ITitle {
        IImagePath title(String title);
    }

    public interface IImagePath {
        IPopularity imagePath(String url);
    }

    public interface IPopularity {
        IVoteAverage popularity(double popularity);
    }

    public interface IVoteAverage {
        IBuild votesAvg(double votes);
    }

    public interface IBuild {
        ListMovieModel build();
    }

    public static ITitle id(int id) {
        return new ListMovieModel.Builder(id);
    }

    private static class Builder implements ITitle, IImagePath, IPopularity, IVoteAverage, IBuild {

        private ListMovieModel instance = new ListMovieModel();

        public Builder(int id) {
            instance.id = id;
        }

        @Override
        public ListMovieModel build() {
            return instance;
        }

        @Override
        public IVoteAverage popularity(double popularity) {
            instance.popularity = popularity;
            return this;
        }

        @Override
        public IPopularity imagePath(String url) {
            instance.image_path = url;
            return this;
        }

        @Override
        public IImagePath title(String title) {
            instance.title = title;
            return this;
        }

        @Override
        public IBuild votesAvg(double votes) {
            instance.vote_average = votes;
            return this;
        }
    }
}
