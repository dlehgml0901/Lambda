package com.lamda.web.mappers;

import com.lamda.web.Movie.MovieDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMapper {
    public int count();
    public void insertMovie();
}
