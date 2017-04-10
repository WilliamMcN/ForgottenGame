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
//this class here is what creates the shopItems
public class MarketTypes {
    private String itemName;
    private int priceOfItem, itemStatBonus, bonusType;

    public MarketTypes(String itemName, int priceOfItem, int itemStatBonus, int bonusType) {
        this.itemName = itemName;
        this.priceOfItem = priceOfItem;
        this.itemStatBonus = itemStatBonus;
        this.bonusType = bonusType;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPriceOfItem() {
        return priceOfItem;
    }

    public int getItemStatBonus() {
        return itemStatBonus;
    }

    public int getBonusType() {
        return bonusType;
    }
    
    
    
}
