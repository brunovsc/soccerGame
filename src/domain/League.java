/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

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
        int [] ids = new int[teams.size()];
        for(int i = 0; i < teams.size(); i++){
            Team team = teams.get(i);
            teamStats.add(new TeamStats(team));
            ids[i] = team.getId();
            for(int j = i+1; j < teams.size(); j++){
                Team otherTeam = teams.get(j);
                if(team != otherTeam){
                    if((j+i)%2 == 0){
                        matches.add(new Match(0, otherTeam, team));
                    } else {
                        matches.add(new Match(0, team, otherTeam));
                    }
                }
            }
        }
        
        int matchesForRound = teams.size() / 2;
        int matchesTaken;
        ArrayList<Integer> teamsTaken = new ArrayList<>();
        ArrayList<Match> matchesUsed = new ArrayList<>();
        for(int r = 0; r < nRounds/2; r++){
            matchesTaken = 0;
            teamsTaken.clear();
            Round round = rounds.get(r);
            Round reRound = rounds.get(nRounds/2 + r);
            for(int i = 0; i < matches.size(); i++){
                Match match = matches.get(i);
                if(!matchesUsed.contains(match)){
                    if(!teamsTaken.contains(match.getHomeTeam().getId()) && !teamsTaken.contains(match.getAwayTeam().getId())){
                        teamsTaken.add(match.getHomeTeam().getId());
                        teamsTaken.add(match.getAwayTeam().getId());                    
                        matchesTaken++;
                        match.setRound(r + 1);
                        round.getMatches().add(match);
                        reRound.getMatches().add(new Match(match.getRound() + nRounds/2, match.getAwayTeam(), match.getHomeTeam()));
                        matchesUsed.add(match);
                    }
                }
                if(matchesTaken == matchesForRound){
                    break;
                }
            }
        }
        
//        printMatches(matches);
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
    
    public void verifyTable(){
            System.out.println();
            System.out.println();
        int [][] table = new int[teamStats.size()][teamStats.size()];
        for(int i = 0; i < teamStats.size(); i++){
            for(int j = 0; j < teamStats.size(); j++){
                table[i][j] = -1;
            }
        }
        for(Round round: rounds){
            for(Match match: round.getMatches()){
                table[match.getHomeTeam().getId() - 1][match.getAwayTeam().getId() - 1] = match.getRound();
            }
        }
        
        for(int i = 0; i < teamStats.size(); i++){
            for(int j = 0; j < teamStats.size(); j++){
                System.out.printf("\t%d", table[i][j]);
            }
            System.out.println();
        }
            System.out.println();
    }
    
    
    public void simulate(){
        for(int i = 0; i < rounds.size(); i++){
            simulateRound(rounds.get(i));
        }
    }
    
    public void simulateRound(Round round){
        ArrayList<Match> matches = round.getMatches();
        for(int i = 0; i < matches.size(); i++){
            simulateMatch(matches.get(i));
        }
    }
    
    public void simulateMatch(Match match){
        int homeGoals = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        int awayGoals = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        match.setHomeTeamGoals(homeGoals);
        match.setAwayTeamGoals(awayGoals);
        for(TeamStats teamStat: teamStats){
            if(teamStat.getTeam().equals(match.getHomeTeam())){
                Constants.Results result = homeGoals == awayGoals ? Constants.Results.DRAW : (homeGoals > awayGoals ? Constants.Results.WIN : Constants.Results.LOSS);
                teamStat.addResult(result);
            }
            if(teamStat.getTeam().equals(match.getAwayTeam())){
                Constants.Results result = awayGoals == homeGoals ? Constants.Results.DRAW : (awayGoals > homeGoals ? Constants.Results.WIN : Constants.Results.LOSS);
                teamStat.addResult(result);
                break;
            }
        }
    }
    
    public void sortByPoints(){
        Collections.sort(teamStats, new Comparator<TeamStats>(){
            @Override
            public int compare(TeamStats o1, TeamStats o2){
                if(o1.getPoints() == o2.getPoints())
                    return 0;
                return o1.getPoints() < o2.getPoints() ? 1 : -1;
            }
        });
    }
    
}


