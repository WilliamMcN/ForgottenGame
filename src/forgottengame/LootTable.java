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
public class LootTable {
    private String lootName;
    private int lootBonus, lootType, lootCode;

    public LootTable(String lootName, int lootBonus, int lootType, int lootCode) {
        this.lootName = lootName;
        this.lootBonus = lootBonus;
        this.lootType = lootType;
        this.lootCode = lootCode;
    }

    public String getLootName() {
        return lootName;
    }

    public int getLootBonus() {
        return lootBonus;
    }

    public int getLootType() {
        return lootType;
    }

    public int getLootCode() {
        return lootCode;
    }
    
    
    
}
