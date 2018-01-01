/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domain.Formation;
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
public class FormationRepository {
    
    private static FormationRepository instance;
    
    private static ArrayList<Formation> formations;
    
    public static FormationRepository getInstance(){
        if(instance == null){
            instance = new FormationRepository();
        }
        return instance;
    }
    
    private FormationRepository(){
        loadFormations();
    }
    
    private void loadFormations(){
        ArrayList<Formation> formations = new ArrayList<>();
        
        try {
            String content = new String(Files.readAllBytes(Paths.get("./src/inputData/formations.txt")));
            JSONObject obj = new JSONObject(content);
            JSONArray formationsArrayObj = obj.getJSONArray("formations");
            for (int i = 0; i < formationsArrayObj.length(); i++){
                JSONObject formationObj = formationsArrayObj.getJSONObject(i);
                ArrayList<String> positions = new ArrayList<>();
                JSONArray positionsArray = formationObj.getJSONArray("positions");
                for(int j = 0; j < positionsArray.length(); j++){
                    positions.add(positionsArray.getString(j));
                }
                formations.add(new Formation(
                        formationObj.getInt("id"), 
                        formationObj.getString("name"), 
                        formationObj.getDouble("attack"), 
                        formationObj.getDouble("defense"), 
                        positions));
            }
        } catch (IOException ex) {
            Logger.getLogger(StadiumRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.formations = formations;
    }

    public static ArrayList<Formation> getFormations() {
        return formations;
    }
    
    public static Formation getFormationWithId(int formationId){
        for(Formation formation: formations){
            if(formation.getId() == formationId){
                return formation;
            }
        }
        return null;
    }
}
