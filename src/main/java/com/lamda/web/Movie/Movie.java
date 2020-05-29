package com.lamda.web.Movie;

import lombok.Builder;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "movie")
@Component
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long movieNo;
    @Column(length = 4) private String rank;
    @Column(length = 100) private String movieName;
    @Column(length = 10) private String rankDate;

    public Movie(){}

    public Long getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(Long movieNo) {
        this.movieNo = movieNo;
    }

    public String getRank() { return rank; }

    public void setRank(String rank) { this.rank = rank; }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRankDate() { return rankDate; }

    public void setRankDate(String rankDate) { this.rankDate = rankDate; }

    @Override
    public String toString() {
        return "Movie{" +
                "movieNo=" + movieNo +
                ", rank='" + rank + '\'' +
                ", movieName='" + movieName + '\'' +
                ", rankDate='" + rankDate + '\'' +
                '}';
    }

    @Builder
    public Movie(String rank, String movieName, String rankDate){
        this.rank = rank;
        this.movieName = movieName;
        this.rankDate = rankDate;
    }
}
