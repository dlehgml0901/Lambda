package com.lamda.web.Movie;

import lombok.Builder;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "movie")
@Component
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long movieNo;
    @Column(length = 4) private String ranking;
    @Column(length = 50) private String movieName;

    public Movie(){}

    public Long getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(Long movieNo) {
        this.movieNo = movieNo;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieNo=" + movieNo +
                ", ranking='" + ranking + '\'' +
                ", movieName='" + movieName + '\'' +
                '}';
    }

    @Builder
    public Movie(String ranking, String movieName){
        this.ranking = ranking;
        this.movieName = movieName;
    }
}
