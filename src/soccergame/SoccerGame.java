/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccergame;

import domain.Formation;
import domain.Player;
import domain.Stadium;
import domain.Team;
import java.util.ArrayList;
import repository.FormationRepository;
import repository.StadiumRepository;
import repository.TeamRepository;

/**
 *
 * @author Bruno
 */
public class SoccerGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Formation> formations = FormationRepository.getInstance().getFormations();
        for(Formation formation: formations){
            printFormation(formation);
        }
        System.out.println("");
        ArrayList<Stadium> stadiums = StadiumRepository.getInstance().getStadiums();
        for(Stadium stadium: stadiums){
            printStadium(stadium);
        }
        System.out.println("");
        ArrayList<Team> teams = TeamRepository.getInstance().getTeams();
        for(Team team: teams){
            printTeam(team);
        }
    }
    
    public static void printStadium(Stadium stadium){
        System.out.printf("Stadium: %d - %s - Capacity: %d \n", stadium.getId(), stadium.getName(), stadium.getCapacity());
    }
    
    public static void printTeam(Team team){
        Stadium stadium = StadiumRepository.getStadiumWithId(team.getStadiumId());
        Formation formation = FormationRepository.getFormationWithId(team.getFormationId());
        System.out.printf("Team: %s - Stadium: %s - Formation: %s\n", team.getName(), stadium.getName(), formation.getName());
        for(Player player: team.getPlayers()){
            System.out.print("    ");
            printPlayer(player);
        }
        System.out.println("");
    }
    
    public static void printPlayer(Player player){
        System.out.printf("Player: %s - Overall: %d - Age: %d - %s - Shirt: %d - %s %s\n", player.getDisplayName(), player.getOverall(), player.getAge(), player.getNationality(), player.getShirtNumber(), player.getFirstName(), player.getLastName());
    }
    
    public static void printFormation(Formation formation){
        System.out.printf("Formation: %d  %s (%f, %f) - ", formation.getId(), formation.getName(), formation.getAttackMultiplier(), formation.getDefenseMultiplier());
        System.out.print("[ ");
        for(int i = 0; i < 11; i++){
            System.out.print(formation.getPositions().get(i)+ " ");
        }
        System.out.print("]\n");
    }
    
}
