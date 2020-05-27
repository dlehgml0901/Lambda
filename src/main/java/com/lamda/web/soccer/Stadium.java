package com.lamda.web.soccer;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "stadium")
public class Stadium {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long stadiumNo;
    @Column(length = 10, nullable = false)
    private String stadium_id;
    @Column(length = 40, nullable = false)
    private String stadium_name;
    @Column(length = 10, nullable = false)
    private String hometeam_id;
    @Column(length = 11, nullable = false)
    private String seat_count;
    @Column(length = 60, nullable = false)
    private String address;
    @Column(length = 10, nullable = false)
    private String ddd;
    @Column(length = 10, nullable = false)
    private String tel;
    @Builder
    public Stadium(String stadium_id, String stadium_name, String hometeam_id,
                   String seat_count, String address, String ddd, String tel){
        this.stadium_id = stadium_id;
        this.stadium_name = stadium_name;
        this.hometeam_id = hometeam_id;
        this.seat_count = seat_count;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
    }
    @OneToMany(mappedBy = "stadium")
    private List<Team> teams;

    @OneToMany(mappedBy = "stadium")
    private List<Schedule> schedules;
}
