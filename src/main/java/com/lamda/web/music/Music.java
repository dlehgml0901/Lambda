package com.lamda.web.music;

import lombok.*;

import javax.persistence.*;

//ddd
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "music")
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long misicNo;
    @Column(length = 4, nullable = false)
    private String seq;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(length = 30, nullable = false)
    private String artist;
    @Column(length = 200, nullable = false)
    private String thumbnail;
    @Builder
    public Music(String seq, String title, String artist, String thumbnail){
        this.seq = seq;
        this.title = title;
        this.artist = artist;
        this.thumbnail = thumbnail;
    }
}
