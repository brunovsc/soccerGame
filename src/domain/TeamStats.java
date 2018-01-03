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
    
    public void addResult(Constants.Results result){
        if(result != null) switch (result) {
            case LOSS:
                losses++;
                break;
            case DRAW:
                draws++;
                break;
            case WIN:
                wins++;
                break;
            default:
                break;
        }
        form.add(result);
    }

    public Team getTeam() {
        return team;
    }
    
    public int getPoints() {
        return wins * 3 + draws * 1;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public ArrayList<Constants.Results> getForm() {
        return form;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalsScored() {
        return goalsScored;
    }
    
    
    
}
