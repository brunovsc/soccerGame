/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Bruno
 */
public class TeamStats {
    private Team team;
    
    private int wins;
    private int draws;
    private int losses;
    
    private int goalsScored;
    private int goalsAgainst;
    
    TeamStats(Team team){
        this.team = team;
        wins = draws = losses = goalsScored = goalsAgainst = 0;
    }
}
