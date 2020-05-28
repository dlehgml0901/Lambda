package com.lamda.web.soccer;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//JPA
@Data

//@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name = "player") @Lazy
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerNo;
    @NotNull
    @Column(length = 10) private String playerId;
    @Column(length = 20) private String player_name;
    @Column(length = 40) private String e_player_name;
    @Column(length = 30) private String nickname;
    @Column(length = 10) private String join_yyyy;
    @Column(length = 10) private String position;
    @Column(length = 10) private String back_no;
    @Column(length = 20) private String nation;
    @Column(length = 20) private String birth_date;
    @Column(length = 10) private String solar;
    @Column(length = 10) private String height;
    @Column(length = 10) private String weight;
    public Player(){}

    public Long getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(Long playerNo) {
        this.playerNo = playerNo;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getE_player_name() {
        return e_player_name;
    }

    public void setE_player_name(String e_player_name) {
        this.e_player_name = e_player_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getJoin_yyyy() {
        return join_yyyy;
    }

    public void setJoin_yyyy(String join_yyyy) {
        this.join_yyyy = join_yyyy;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBack_no() {
        return back_no;
    }

    public void setBack_no(String back_no) {
        this.back_no = back_no;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getSolar() {
        return solar;
    }

    public void setSolar(String solar) {
        this.solar = solar;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Team getTeam() {
        return teamOfPlayer;
    }

    public void setTeam(Team teamOfPlayer) {
        this.teamOfPlayer = teamOfPlayer;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerNo=" + playerNo +
                ", playerId='" + playerId + '\'' +
                ", player_name='" + player_name + '\'' +
                ", e_player_name='" + e_player_name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", join_yyyy='" + join_yyyy + '\'' +
                ", position='" + position + '\'' +
                ", back_no='" + back_no + '\'' +
                ", nation='" + nation + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", solar='" + solar + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", team=" + teamOfPlayer +
                '}';
    }

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
    @JoinColumn(name = "team_id")
    private Team teamOfPlayer;
}