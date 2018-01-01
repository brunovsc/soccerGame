/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domain.Player;
import domain.PlayerPosition;
import domain.Team;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
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
public class TeamRepository {
    private static TeamRepository instance;
    
    private static ArrayList<Team> teams;
    
    public static TeamRepository getInstance(){
        if(instance == null){
            instance = new TeamRepository();
        }
        return instance;
    }
    
    private TeamRepository(){
        loadTeams();
    }
    
    private void loadTeams(){
        ArrayList<Team> teams = new ArrayList<>();
        
        try {
            String content = new String(Files.readAllBytes(Paths.get("./src/inputData/teams.txt")));
            JSONObject obj = new JSONObject(content);
            JSONArray teamsArrayObj = obj.getJSONArray("teams");
            for (int i = 0; i < teamsArrayObj.length(); i++){
                JSONObject teamObj = teamsArrayObj.getJSONObject(i);
                ArrayList<Player> players = new ArrayList<>();
                JSONArray playersArrayObj = teamObj.getJSONArray("players");
                for(int j = 0; j < playersArrayObj.length(); j++){
                    JSONObject playerObj = playersArrayObj.getJSONObject(j);
                    players.add(new Player(
                            playerObj.getString("firstName"), 
                            playerObj.getString("lastName"), 
                            playerObj.getString("displayName"), 
                            PlayerPosition.getPlayerPositionWithShortName(playerObj.getString("position")), 
                            playerObj.getInt("overall"), 
                            playerObj.getInt("shirtNumber"),
                            playerObj.getString("nationality"),
                            playerObj.getInt("age")));
                }
                teams.add(new Team(teamObj.getInt("id"), teamObj.getString("name"), teamObj.getInt("stadiumId"), teamObj.getInt("formationId"), players));
            }
        } catch (IOException ex) {
            Logger.getLogger(StadiumRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.teams = teams;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }    
}
