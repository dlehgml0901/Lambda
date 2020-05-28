package com.lamda.web.proxy;

import com.lamda.web.soccer.Player;
import com.lamda.web.soccer.PlayerDTO;
import com.lamda.web.soccer.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.*;

@Component("uploader") @Lazy
public class FileUploader extends Proxy{
    @Autowired Inventory<String> inventory;
    @Autowired PlayerRepository playerRepository;

    public void upload(){
        inventory.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\user\\IdeaProjects\\lamda\\src\\main\\resources\\static\\files\\player.csv")));
            String player = "";
            while ((player = reader.readLine()) != null){
                inventory.add(player);
            }
        }catch(Exception e){
            print("파일 리딩 에러");
            e.printStackTrace();
        }
        print("---------------------------------------\n");
        print(inventory.get().get(0).toString());
        String[] arr = inventory.get().get(0).toString().split(",");
        //"2000003","유동우","K10","YOU,  DONGWOO","","","DF","40","","07-MAR-1978","1","177","70"
        Player p = new Player();
        p.setPlayerId(arr[0]);
        p.setPlayer_name(arr[1]);
        p.setE_player_name(arr[3]);
        p.setNickname(arr[4]);
        p.setJoin_yyyy(arr[5]);
        p.setPosition(arr[6]);
        p.setBack_no(arr[7]);
        p.setNation(arr[8]);
        p.setBirth_date(arr[9]);
        p.setSolar(arr[10]);
        p.setHeight(arr[11]);
        p.setWeight(arr[12]);
        print("---------------------------------------\n");
        print(p.toString());
        playerRepository.save(p);
    }
}
