/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgottengame;



/**
 *
 * @author williammc
 */
public class PlayerStats {
    private String playerName;
    private int playerCoins, playerAttack, playerAmour;
    private double playerHeath;

    public PlayerStats(String playerName, int playerCoins, int playerAttack, int playerAmour, double playerHeath) {
        this.playerName = playerName;
        this.playerCoins = playerCoins;
        this.playerAttack = playerAttack;
        this.playerAmour = playerAmour;
        this.playerHeath = playerHeath;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerCoins() {
        return playerCoins;
    }

    public int getPlayerAttack() {
        return playerAttack;
    }

    public int getPlayerAmour() {
        return playerAmour;
    }

    public double getPlayerHeath() {
        return playerHeath;
    }
    
    
}
