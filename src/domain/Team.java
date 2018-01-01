/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class Team {
    private int id;
    private String name;
    private int stadiumId;
    private int formationId;
    private ArrayList<Player> players;
    
    public Team(int id, String name, int stadiumId, int formationId, ArrayList<Player> players){
        this.id = id;
        this.name = name;
        this.stadiumId = stadiumId;
        this.formationId = formationId;
        this.players = players;
    }

    public int getFormationId() {
        return formationId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getStadiumId() {
        return stadiumId;
    }
}
