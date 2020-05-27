package com.lamda.web.soccer;

import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "team")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamNo;
    @Column(length = 10, nullable = false)
    private String team_id;
    @Column(length = 10, nullable = false)
    private String region_name;
    @Column(length = 40, nullable = false)
    private String team_name;
    @Column(length = 50, nullable = false)
    private String e_team_name;
    @Column(length = 10, nullable = false)
    private String orig_yyyy;
    @Column(length = 10, nullable = false)
    private String zip_code1;
    @Column(length = 10, nullable = false)
    private String zip_code2;
    @Column(length = 80, nullable = false)
    private String address;
    @Column(length = 10, nullable = false)
    private String ddd;
    @Column(length = 10, nullable = false)
    private String tel;
    @Column(length = 10, nullable = false)
    private String fax;
    @Column(length = 50, nullable = false)
    private String homepage;
    @Column(length = 10, nullable = false)
    private String team_owner;
    @Builder
    public Team(String team_id, String region_name, String team_name,
                String e_team_name, String orig_yyyy,
                String zip_code1, String zip_code2, String address, String ddd,
                String tel, String fax, String homepage, String team_owner){
        this.team_id = team_id;
        this.region_name = region_name;
        this.team_name = team_name;
        this.e_team_name = e_team_name;
        this.orig_yyyy = orig_yyyy;
        this.zip_code1 = zip_code1;
        this.zip_code2 = zip_code2;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
        this.fax = fax;
        this.homepage = homepage;
        this.team_owner = team_owner;
    }
    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id") @NotNull
    private Stadium stadium;

}
