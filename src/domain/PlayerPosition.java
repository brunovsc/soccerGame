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
public enum PlayerPosition {
    GOALKEEPER("GK"),
    CENTER_BACK("CB"),
    LEFT_BACK("LB"),
    RIGHT_BACK("RB"),
    DEFENSIVE_MID("DM"),
    CENTER_MID("CM"),
    LEFT_MID("LM"),
    RIGHT_MID("RM"),
    ATTACK_MID("AM"),
    LEFT_WING("LW"),
    RIGHT_WING("RW"),
    STRIKER("ST"),
    ERROR("ER");
    
    private final String shortName;
    
    PlayerPosition(String shortName){
       this.shortName = shortName; 
    }
    
    public String getShortName(){
        return shortName;
    }
    
    public static PlayerPosition getPlayerPositionWithShortName(String shortName){
        if(shortName.equals("GK")) return GOALKEEPER;
        else if(shortName.equals("CB")) return CENTER_BACK;
        else if(shortName.equals("LB")) return LEFT_BACK;
        else if(shortName.equals("RB")) return RIGHT_BACK;
        else if(shortName.equals("DM")) return DEFENSIVE_MID;
        else if(shortName.equals("CM")) return CENTER_MID;
        else if(shortName.equals("LM")) return LEFT_MID;
        else if(shortName.equals("RM")) return RIGHT_MID;
        else if(shortName.equals("AM")) return ATTACK_MID;
        else if(shortName.equals("LW")) return LEFT_WING;
        else if(shortName.equals("RW")) return RIGHT_WING;
        else if(shortName.equals("ST")) return STRIKER;
        else return ERROR;
    }
}
