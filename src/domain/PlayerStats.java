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
public class PlayerStats {
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
    private int cleanSheets;
    private int form;
    private ArrayList<Player> playerChemistry;
    
    public PlayerStats(){
        goals = assists = yellowCards = redCards = cleanSheets = 0;
        form = 5;
        playerChemistry = new ArrayList<>();
    }
    
    
    
}
