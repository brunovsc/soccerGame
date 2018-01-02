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
public class TeamStats {
    private Team team;
    
    private int wins;
    private int draws;
    private int losses;
    
    private int goalsScored;
    private int goalsAgainst;
    
    private ArrayList<Constants.Results> form;
    
    TeamStats(Team team){
        this.team = team;
        wins = draws = losses = goalsScored = goalsAgainst = 0;
        form = new ArrayList<>();
    }
    
    public void addResultFromMatch(Match match){
        Team winningTeam = match.getWinningTeam();
        Constants.Results result;
        if(winningTeam == null){
            result = Constants.Results.DRAW;
            draws++;
        } else {
            if(winningTeam.equals(this.team)){
                result = Constants.Results.WIN;
                wins++;
            } else {
                result = Constants.Results.LOSS;
                losses++;
            }
        }
        form.add(result);
    }
    
    
}
