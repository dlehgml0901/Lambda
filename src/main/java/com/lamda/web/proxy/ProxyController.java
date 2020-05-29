package com.lamda.web.proxy;

import com.lamda.web.Movie.Movie;
import com.lamda.web.Movie.MovieRepository;
import com.lamda.web.music.Music;
import com.lamda.web.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class ProxyController{
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired Proxy pxy;
    @Autowired FileUploader uploader;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieRepository movieRepository;

    @GetMapping("/navermovie/{searchWord}")
    public void navermovie(@PathVariable String searchWord){
        pxy.print("넘어온 키워드: "+searchWord);
        crawler.navermovie();
    }

    @PostMapping("/bugsmusic")
    public HashMap<String, Object> bugsmusic(@RequestBody String searchWord){
        pxy.print("넘어온 키워드 : " + searchWord);
        box.clear();
        if (musicRepository.count() == 0) crawler.bugsMusic();
        List<Music> list = musicRepository.findAll();
        pxy.print("count :"+list.size());
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }

    @GetMapping("/soccer/{searchWord}")
    public HashMap<String,String> soccer(@PathVariable String searchWord){
        pxy.print("넘어온키워드: "+ searchWord);
        uploader.upload();
        return null;
    }
}
