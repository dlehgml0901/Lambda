package com.lamda.web.Movie;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MovieDTO {
    private String rank, movieName, rankDate;
}
