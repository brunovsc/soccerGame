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
public class Formation {
    private int id;
    private String name;
    private double attackMultiplier;
    private double defenseMultiplier;
    private ArrayList<String> positions;

    public Formation(int id, String name, double attackMultiplier, double defenseMultiplier, ArrayList<String> positions) {
        this.id = id;
        this.name = name;
        this.attackMultiplier = attackMultiplier;
        this.defenseMultiplier = defenseMultiplier;
        this.positions = positions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAttackMultiplier() {
        return attackMultiplier;
    }

    public double getDefenseMultiplier() {
        return defenseMultiplier;
    }

    public ArrayList<String> getPositions() {
        return positions;
    }
}
