package com.lamda.web.mappers;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "player_2")
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    @Column(length = 20, nullable = false)
    private String player_name;
    @Column(length = 10, nullable = false)
    private String team_id;
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
    public Player(String player_name, String team_id, String e_player_name,
                  String nickname, String join_yyyy, String position, String back_no,
                  String nation, String birth_date, String solar, String height, String weight){
        this.player_name = player_name;
        this.team_id = team_id;
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

}
