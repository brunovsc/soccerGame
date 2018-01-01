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
public class Stadium {
    private int id;
    private String name;
    private int capacity;
        
    public Stadium(int id, String name, int capacity){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
}
