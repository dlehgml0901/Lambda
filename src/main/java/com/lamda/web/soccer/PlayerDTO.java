package com.lamda.web.soccer;

import lombok.Data;
import org.springframework.stereotype.Component;

//mybatis
@Component
@Data
public class PlayerDTO {
    private String playerId, player_name, e_player_name, nickname, join_yyyy,
            position,  back_no,  nation, birth_date, solar,
            height, weight;
}
