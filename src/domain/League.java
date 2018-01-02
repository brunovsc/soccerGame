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
public class League {
    private ArrayList<TeamStats> teamStats; // ordered by points
    private ArrayList<Round> rounds;

    public League(ArrayList<Team> teams) {
        teamStats = new ArrayList<>();
        rounds = new ArrayList<>();
        int nRounds = (teams.size() * 2) - 2;
        for(int i = 0; i < nRounds; i++){ // home and away
            rounds.add(new Round(i + 1));
        }       
        
        ArrayList<Match> matches = new ArrayList<>();
        
        for(Team team: teams){
            teamStats.add(new TeamStats(team));
            for(Team otherTeam: teams){
                if(team != otherTeam){
                    matches.add(new Match(0, team, otherTeam));
                }
            }
        }
        
        
    }
    public void printMatches(ArrayList<Match> matches){
        for(Match match: matches){
            System.out.print("    ");
            printMatch(match);
        }
    }
    
    public static void printMatch(Match match){
        System.out.printf("%s X %s\n", match.getHomeTeam().getName(), match.getAwayTeam().getName());
    }
        
    
    
    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public ArrayList<TeamStats> getTeamStats() {
        return teamStats;
    }
    
    
}
