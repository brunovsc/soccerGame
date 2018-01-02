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
public class Match {
    private int round;
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamGoals;
    private int awayTeamGoals;

    public Match(int round, Team homeTeam, Team awayTeam){
        this.round = round;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        homeTeamGoals = awayTeamGoals = 0;
    }
    
    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getRound() {
        return round;
    }
    
    public Team getWinningTeam() {
        if(homeTeamGoals > awayTeamGoals) return homeTeam;
        if(homeTeamGoals < awayTeamGoals) return awayTeam;
        return null;
    }
}
