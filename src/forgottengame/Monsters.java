/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgottengame;

import javafx.scene.image.Image;



/**
 *
 * @author williammc
 */
//this class here is what creates the monsterClass for the game
public class Monsters {
    private String monsterName;
    private int monsterHeath, monsterAttack, monsterLevel, monsterExp;
    private Image monsterImage;

    public Monsters(String monsterName, int monsterHeath, int monsterAttack, int monsterLevel, Image monsterImage, int monsterExp) {
        this.monsterName = monsterName;
        this.monsterHeath = monsterHeath;
        this.monsterAttack = monsterAttack;
        this.monsterLevel = monsterLevel;
        this.monsterImage = monsterImage;
        this.monsterExp = monsterExp;
        
    }

    public String getMonsterName() {
        return monsterName;
    }

    public int getMonsterHeath() {
        return monsterHeath;
    }

    public int getMonsterAttack() {
        return monsterAttack;
    }

    public int getMonsterLevel() {
        return monsterLevel;
    }

    public Image getMonsterImage() {
        return monsterImage;
    }

    public int getMonsterExp() {
        return monsterExp;
    }
    
    
    
}
