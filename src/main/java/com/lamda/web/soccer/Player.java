package com.lamda.web.soccer;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "player")
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerNo;
    @Column(length = 20, nullable = false)
    private String playerId;
    @Column(length = 10, nullable = false)
    private String player_name;
    @Column(length = 40, nullable = false)
    private String e_player_name;
    @Column(length = 30, nullable = false)
    private String nickname;
    @Column(length = 10, nullable = false)
    private String join_yyyy;
    @Column(length = 10, nullable = false)
    private String position;
    @Column(length = 20, nullable = false)
    private String back_no;
    @Column(length = 20, nullable = false)
    private String nation;
    @Column(length = 20, nullable = false)
    private String birth_date;
    @Column(length = 10, nullable = false)
    private String solar;
    @Column(length = 10, nullable = false)
    private String height;
    @Column(length = 10, nullable = false)
    private String weight;
    @Builder
    public Player(String playerId, String player_name, String e_player_name,
                  String nickname, String join_yyyy, String position, String back_no,
                  String nation, String birth_date, String solar, String height, String weight){
        this.playerId = playerId;
        this.player_name = player_name;
        this.e_player_name = e_player_name;
        this.nickname = nickname;
        this.join_yyyy = join_yyyy;
        this.position = position;
        this.back_no = back_no;
        this.nation = nation;
        this.birth_date = birth_date;
        this.solar = solar;
        this.height = height;
        this.weight = weight;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id") @NotNull
    private Team team;
}