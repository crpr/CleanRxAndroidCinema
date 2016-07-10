package com.crpr.androidcinema.data.api.responses;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cribeiro on 23/05/2016.
 */
public class ApiResponse<T> implements Serializable {

    private int page;
    private int total_pages;
    private int total_results;
    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public int getTotalResults() {
        return total_results;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotalPages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setTotalResults(int total_results) {
        this.total_results = total_results;
    }
}
