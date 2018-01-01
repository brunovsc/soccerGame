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
public class Player {
    private String firstName;
    private String lastName;
    private String displayName;
    private PlayerPosition position;
    private int overall;
    private int shirtNumber;

    public Player(String firstName, String lastName, String displayName, PlayerPosition position, int overall, int shirtNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.position = position;
        this.overall = overall;
        this.shirtNumber = shirtNumber;
    }
    
    public String getDisplayName() {
        return displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getOverall() {
        return overall;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }    
}