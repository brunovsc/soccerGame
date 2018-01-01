/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domain.Stadium;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bruno
 */
public class StadiumRepository {
    
    private static StadiumRepository instance;
    
    private static ArrayList<Stadium> stadiums;
    
    public static StadiumRepository getInstance(){
        if(instance == null){
            instance = new StadiumRepository();
        }
        return instance;
    }
    
    private StadiumRepository(){
        loadStadiums();
    }
    
    private void loadStadiums(){
        ArrayList<Stadium> stadiums = new ArrayList<>();
        
        try {
            String content = new String(Files.readAllBytes(Paths.get("./src/inputData/stadiums.txt")));
            JSONObject obj = new JSONObject(content);
            JSONArray stadiumsArrayObj = obj.getJSONArray("stadiums");
            for (int i = 0; i < stadiumsArrayObj.length(); i++){
                JSONObject stadiumObj = stadiumsArrayObj.getJSONObject(i);
                stadiums.add(new Stadium(stadiumObj.getInt("id"), stadiumObj.getString("name"), stadiumObj.getInt("capacity")));
            }
        } catch (IOException ex) {
            Logger.getLogger(StadiumRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.stadiums = stadiums;
    }

    public ArrayList<Stadium> getStadiums() {
        return stadiums;
    }   
    
    public static Stadium getStadiumWithId(int stadiumId){
        for(Stadium stadium: stadiums){
            if(stadium.getId() == stadiumId){
                return stadium;
            }
        }
        return null;
    }
}
