package com.lamda.web.soccer;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "schedule")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleNo;
    @Column(length = 10, nullable = false)
    private String sche_date;
    @Column(length = 10, nullable = false)
    private String gubun;
    @Column(length = 10, nullable = false)
    private String hometeam_id;
    @Column(length = 10, nullable = false)
    private String awayteam_id;
    @Column(length = 10, nullable = false)
    private String home_score;
    @Column(length = 10, nullable = false)
    private String away_score;
    @Builder
    public Schedule(String sche_date, String gubun,
                    String hometeam_id, String awayteam_id, String home_score, String away_score){
        this.sche_date = sche_date;
        this.gubun = gubun;
        this.hometeam_id = hometeam_id;
        this.awayteam_id = awayteam_id;
        this.home_score = home_score;
        this.away_score = away_score;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id") @NotNull
    private Stadium stadiumOfSchedule;
}
