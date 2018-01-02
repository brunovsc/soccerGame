/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Bruno Vieira
 */
public class Round {
    private int number;
    private ArrayList<Match> matches;

    public Round(int number){
        this.number = number;
        matches = new ArrayList<>();
    }
    
    public ArrayList<Match> getMatches() {
        return matches;
    }

    public int getNumber() {
        return number;
    }
}
