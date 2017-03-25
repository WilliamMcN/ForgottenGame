/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgottengame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author williammc
 */
public class ForgottenMaze 
{
    public static void main(String[] args)
    {
        double heath = 200;
        int exp = 0;
        ArrayList<String> itemlist = new ArrayList<>();
        Random rand= new Random();
        int end = 0;
        int attack = 100;
        int defence = 6;
        int run = 2;
        int level = 1;
        int levelRank = 200;
        int coins = 100;
        int pick = 0;
        int floorLevel = 1;
        int monsterUpgrade = 1;
        int armour = 5;
        int monsterLoot = 0;
        int lootbonus =0;
        int armourDamage=0;
        int breakArmour=0;
        int totalHeath =0;
        breakArmour = rand.nextInt(20) + 10;
        Scanner keyboard = new Scanner (System.in);
        
        while (end == 0)
        {  
            //MonsterLoot using 
            lootbonus =0;
            if (monsterLoot > 0)
            {
                if (monsterLoot <= 3)
                {
                    lootbonus = getHeathBonus(monsterLoot);
                    heath = heath + lootbonus;
                    totalHeath = totalHeath + lootbonus;
                    
                }
                
                if (monsterLoot >= 9 && monsterLoot < 15)
                {
                    lootbonus = getAttackBonus(monsterLoot);
                    attack = attack + lootbonus; 
                }
                 if (monsterLoot >= 4 && monsterLoot < 9)
                {
                    lootbonus = getDefenceBonus(monsterLoot);
                    armour = armour + lootbonus; 
                }
                 if (monsterLoot >= 15)
                {
                    lootbonus = getCoinBonus(monsterLoot);
                    coins = coins + lootbonus; 
                }
                    
            }
             // check lvl and update lvl 
             
             
            int shop = 1;
            System.out.println("Stats:");
            System.out.println("Attack: " + attack);
            System.out.println("Defence: " + armour);
            System.out.println("Heath: " + heath);
            System.out.println("Coins: " + coins);
            System.out.println("Exp: " + exp);
            System.out.println("Level: " + level);
            System.out.println("Floor Level: " + floorLevel);
            System.out.println("");
            System.out.println("");
            
            if (armour > 0)
            {
                System.out.println("Your armour begins to wear");
                armourDamage++;
                System.out.println("armourdamage:" + armourDamage);
                System.out.println("armourbreak:" + breakArmour);
                if (armour <= 25 && armourDamage >= breakArmour && armour > 10)
                {
                  int Damagearmour = rand.nextInt(9) + 1;
                  armour = armour - Damagearmour;
                  breakArmour = rand.nextInt(20) + 10;
                  armourDamage =0;
                  System.out.println("Your armour breaks you lose " + Damagearmour + " armour!" );
                }
                if (armour <= 99 && armourDamage >= breakArmour && armour > 50)
                {
                  int Damagearmour = rand.nextInt(49) + 1;
                  armour = armour - Damagearmour;
                  breakArmour = rand.nextInt(20) + 10;
                  armourDamage =0;
                  System.out.println("Your armour breaks you lose " + Damagearmour + " armour!" );
                  
                }
                if (armour <= 110 && armourDamage >= breakArmour && armour > 100 )
                {
                  int Damagearmour = rand.nextInt(50) + 1;
                  armour = armour - Damagearmour;
                  breakArmour = rand.nextInt(20) + 10;
                  armourDamage =0;
                  System.out.println("Your armour breaks you lose " + Damagearmour + " armour!" );
                  
                }
                if (armourDamage >= breakArmour && armour > 150)
                {
                  int Damagearmour = rand.nextInt(150) + 1;
                  armour = armour - Damagearmour;
                  breakArmour = rand.nextInt(20) + 10;
                  armourDamage =0;
                  System.out.println("Your armour breaks you lose " + Damagearmour + " armour!" );
                }
            }
            
            int start = 7;
            int roll = getDiceRoll(start);
            
            
            while (exp >= levelRank)
            {
                int heathAdd = 50;
                int addHeath = getDiceRoll(heathAdd);
                heath = heath + addHeath;
                int attackAdd = 7;
                int addAttack = getDiceRoll(attackAdd);
                attack = attack + addAttack;
                exp = exp - 1;
                level++;
                levelRank = levelRank + 250;
               System.out.println("You have leveled up to level " + level);
               System.out.println("You need " + levelRank + " to level up!");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("You have rolled a " + roll);
            
            if (roll >= 3 && roll <=6)
            {
                System.out.println("You run into a fight");
                int monster = 6;
                int monsterspawn = getDiceRoll(monster);
                if (monsterspawn == 1)
                {
                    int monsterHeath = 50*monsterUpgrade;
                    int monsterDamage = 16*monsterUpgrade;
                    int monsterLevel = 2;
                    System.out.println("Random Bandit Has Appeard");
                    double fight = getFightMode(monsterHeath, attack, heath, monsterDamage, monsterLevel,armour);
                      if (fight <= 0)
                    {
                        end = 1;
                        System.out.println("You died!");
                    }
                    if (fight > 0)
                    {
                        end = 0;
                        System.out.println("You have defected the monster!");
                        heath = fight;
                    }
                        
                     
                    monsterLoot = getLootTable(monsterLevel);
                    exp = exp + 250;
                    System.out.println("You now have " + exp + " exp");
                }
                if (monsterspawn == 2)
                {
                    int monsterHeath = 30*monsterUpgrade;
                    int monsterDamage = 11*monsterUpgrade;
                    int monsterLevel = 3;
                    System.out.println("Random Goblin Has Appeard");
                    double fight = getFightMode(monsterHeath, attack, heath, monsterDamage, monsterLevel, armour);
                      if (fight <= 0)
                    {
                        end = 1;
                        System.out.println("You died!");
                    }
                    if (fight > 0)
                    {
                        end = 0;
                        System.out.println("You have defected the monster!");
                        heath = fight;
                    }
                    
                        
                    monsterLoot = getLootTable(monsterLevel);
                    exp = exp + 150;
                    System.out.println("You now have " + exp + " exp");
                }
                if (monsterspawn == 3)
                {
                    int monsterHeath = 100*monsterUpgrade;
                    int monsterDamage = 10*monsterUpgrade;
                    int monsterLevel = 6;
                    System.out.println("Random Dwarf (Timber) Has Appeard");
                    double fight = getFightMode(monsterHeath, attack, heath, monsterDamage, monsterLevel, armour);
                      if (fight <= 0)
                    {
                        end = 1;
                        System.out.println("You died!");
                    }
                    if (fight > 0)
                    {
                        end = 0;
                        System.out.println("You have defected the monster!");
                        heath = fight;
                    }
                    
                    monsterLoot = getLootTable(monsterLevel);
                    exp = exp + 200;
                    System.out.println("You now have " + exp + " exp");
                    
                }
                 if (monsterspawn == 4)
                {
                    int monsterHeath = 200*monsterUpgrade;
                    int monsterDamage = 15*monsterUpgrade;
                    int monsterLevel = 5;
                    System.out.println("Random Knight Has Appeard");
                    double fight = getFightMode(monsterHeath, attack, heath, monsterDamage, monsterLevel, armour);
                      if (fight <= 0)
                    {
                        end = 1;
                        System.out.println("You died!");
                    }
                    if (fight > 0)
                    {
                        end = 0;
                        System.out.println("You have defected the monster!");
                        heath = fight;
                    }
                    
                    monsterLoot = getLootTable(monsterLevel);
                    exp = exp + 200;
                    System.out.println("You now have " + exp + " exp");
                }
                if (monsterspawn == 5)
                {
                    int monsterHeath = 400*monsterUpgrade;
                    int monsterDamage = 5*monsterUpgrade;
                    int monsterLevel = 4;
                    System.out.println("Random Zombie Has Appeard");
                    double fight = getFightMode(monsterHeath, attack, heath, monsterDamage, monsterLevel, armour);
                      if (fight <= 0)
                    {
                        end = 1;
                        System.out.println("You died!");
                    }
                    if (fight > 0)
                    {
                        end = 0;
                        System.out.println("You have defected the monster!");
                        heath = fight;
                    }
                    monsterLoot = getLootTable(monsterLevel);
                    exp = exp + 150;
                    System.out.println("You now have " + exp + " exp");
                    
                }
                if (monsterspawn == 6)
                {
                    int monsterHeath = 30*monsterUpgrade;
                    int monsterDamage = 10*monsterUpgrade;
                    int monsterLevel = 1;
                    System.out.println("Random Slime Has Appeard");
                    double fight = getFightMode(monsterHeath, attack, heath, monsterDamage, monsterLevel, armour);
                      if (fight <= 0)
                    {
                        end = 1;
                        System.out.println("You died!");
                    }
                    if (fight > 0)
                    {
                        end = 0;
                        System.out.println("You have defected the monster!");
                        heath = fight;
                    }
                    monsterLoot = getLootTable(monsterLevel);
                    exp = exp + 100;
                    System.out.println("You now have " + exp + " exp");
                    
                }
                    
                
            }
            if (roll == 1 )
            {
                int randomShop = rand.nextInt(5) + 1;
                int findShop = getShop(randomShop);
                if (findShop == 1)
                {
                while (shop <= 1)
                {
                    System.out.println("Heath pots are 10 gp, Strong sword 100 "
                            + "gp,Strong Armour 100 gp ");
                    System.out.println("Please buy an item( 1 = heath pot, 2 = "
                            + "Strong sword, 3 = Strong armour, 4 = leave");
                    int itempick = keyboard.nextInt();
                    System.out.print("the itempick value is " + itempick + "\n");
                    if (itempick == 1)
                    {
                       
                        int itemcheck = getBuy(10,coins,pick);
                        if (itemcheck == 1)
                        {
                         
                            itempick = 0;
                        }
                        if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 10;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You Drink the heath pot");
                            heath = heath + 10;
                            System.out.println("You have" + heath + "heath!");
                            itempick = 0;
                        }
                    }
                    if (itempick == 2)
                    {
                       
                        int itemcheck = getBuy(100,coins,pick);
                        if (itemcheck == 1)
                        {
                            itempick = 0;
                            
                        }
                        else if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 100;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You equip the sword");
                            attack = attack + 4;
                            System.out.println("You have " + attack + " attack!");
                            itempick = 0;
                        }
                        
                    }
                    if (itempick == 3)
                    {
                       
                        int itemcheck = getBuy(100,coins,pick);
                        if (itemcheck == 1)
                        {
                            itempick = 0;
                        }
                        else if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 100;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You equip the armour");
                            armour = armour + 2;
                            System.out.println("You have " + armour + " defence!");
                            itempick = 0;
                        }
                    }
                    if (itempick == 4)
                    {
                      shop = 2;
                    }
                        
                }
                
            }
                if (findShop == 2)
                {
                     while (shop <= 1)
                {
                    System.out.println("Basic helmets are 40 gp, Steel Platelegs 100 "
                            + "gp,Steel Platebody 120 gp ");
                    System.out.println("Please buy an item( 1 = Basic Helmet, 2 = "
                            + "Steel Platelegs, 3 = Steel Platebody, 4 = leave");
                    int itempick = keyboard.nextInt();
                    System.out.print("the itempick value is " + itempick + "\n");
                    if (itempick == 1)
                    {
                       
                        int itemcheck = getBuy(40,coins,pick);
                        if (itemcheck == 1)
                        {
                         
                            itempick = 0;
                        }
                        if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 40;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You put on the helmet");
                            armour = armour + 1;
                            System.out.println("You have" + armour + "armour!");
                            itempick = 0;
                        }
                    }
                    if (itempick == 3)
                    {
                       
                        int itemcheck = getBuy(120,coins,pick);
                        if (itemcheck == 1)
                        {
                            itempick = 0;
                            
                        }
                        else if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 120;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You equip the SteelPlatelegs!");
                            armour = armour + 5;
                            System.out.println("You have " + armour + " defence!");
                            itempick = 0;
                        }
                        
                    }
                    if (itempick == 2)
                    {
                       
                        int itemcheck = getBuy(100,coins,pick);
                        if (itemcheck == 1)
                        {
                            itempick = 0;
                        }
                        else if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 100;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You equip the SteelPlatebody!");
                            armour = armour + 3;
                            System.out.println("You have " + armour + " defence!");
                            itempick = 0;
                        }
                    }
                    if (itempick == 4)
                    {
                      shop = 2;
                    }
                    
                }
              }
            
            if (findShop == 3)
                {
                     while (shop <= 1)
                {
                    System.out.println("Kitchen knife are 40 gp, Steel Sword 120 "
                            + "gp,Steel Broadsword 160 gp ");
                    System.out.println("Please buy an item( 1 = Kitchen Knife, 2 = "
                            + "Steel Sword, 3 = Steel BroadSword , 4 = leave");
                    int itempick = keyboard.nextInt();
                    System.out.print("the itempick value is " + itempick + "\n");
                    if (itempick == 1)
                    {
                       
                        int itemcheck = getBuy(40,coins,pick);
                        if (itemcheck == 1)
                        {
                         
                            itempick = 0;
                        }
                        if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 40;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You equip the Kitchenknife");
                            attack = attack + 1;
                            System.out.println("You have" + attack + "attack!");
                            itempick = 0;
                        }
                    }
                    if (itempick == 2)
                    {
                       
                        int itemcheck = getBuy(120,coins,pick);
                        if (itemcheck == 1)
                        {
                            itempick = 0;
                            
                        }
                        else if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 120;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You equip the Steel Sword");
                            attack = attack + 6;
                            System.out.println("You have " + attack + " attack!");
                            itempick = 0;
                        }
                        
                    }
                    if (itempick == 3)
                    {
                       
                        int itemcheck = getBuy(160,coins,pick);
                        if (itemcheck == 1)
                        {
                            itempick = 0;
                        }
                        else if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 160;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You equip the Steel BroadSword!");
                            attack = attack + 7;
                            System.out.println("You have " + attack + " attack!");
                            itempick = 0;
                        }
                    }
                    if (itempick == 4)
                    {
                      shop = 2;
                    }
                    
                }
              }
            if (findShop == 4)
                {
                     while (shop <= 1)
                {
                    System.out.println("Superpots are 225 gp, Juggernaut Armour are 350"
                            + "gp,Steel Lance 250 gp ");
                    System.out.println("Please buy an item( 1 = Superppots, 2 = "
                            + "Juggernaut Armour, 3 = Steel Lance, 4 = leave");
                    int itempick = keyboard.nextInt();
                    System.out.print("the itempick value is " + itempick + "\n");
                    if (itempick == 1)
                    {
                       
                        int itemcheck = getBuy(225,coins,pick);
                        if (itemcheck == 1)
                        {
                         
                            itempick = 0;
                        }
                        if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 225;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You Drink the heath pot");
                            heath = heath + 200;
                            System.out.println("You have" + heath + "heath!");
                            itempick = 0;
                        }
                    }
                    if (itempick == 2)
                    {
                       
                        int itemcheck = getBuy(350,coins,pick);
                        if (itemcheck == 1)
                        {
                            itempick = 0;
                            
                        }
                        else if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 350;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You equip the juggernaut armour");
                            armour = armour + 10;
                            System.out.println("You have " + armour + " defence!");
                            itempick = 0;
                        }
                        
                    }
                    if (itempick == 3)
                    {
                       
                        int itemcheck = getBuy(250,coins,pick);
                        if (itemcheck == 1)
                        {
                            itempick = 0;
                        }
                        else if (itemcheck == 2)
                        {
                            System.out.println("Sold!");
                            coins = coins - 250;
                            System.out.println("You have " + coins + "coins");
                            System.out.println("Would you like to buy more?");
                            System.out.println("You equip the armour");
                            attack = attack + 12;
                            System.out.println("You have " + attack + " attack!");
                            itempick = 0;
                        }
                    }
                    if (itempick == 4)
                    {
                      shop = 2;
                    }
                    
                }
              }
            if (findShop == 5)
                {
                    System.out.print("Would you like some heathing");
                    System.out.println("I think I know what Im doing");
                    int  randomHeathing = rand.nextInt(10) + 1;
                    if (randomHeathing == 1)
                    {
                        System.out.println("oh got it");
                        heath = totalHeath;
                        System.out.println("Heath is: " + heath);
                        
                    }
                    if (randomHeathing <= 3 && randomHeathing > 1)
                    {
                        System.out.println("so close");
                        if (heath <= totalHeath/2)
                        {
                        heath = totalHeath/2;
                        System.out.println("Heath is: " + heath);
                        }
                        if (heath > totalHeath/2)
                        {
                        heath = heath;
                        System.out.println("Heath is: " + heath);
                        }
                      
                        
                    }
                    if (randomHeathing <= 6 && randomHeathing >= 4)
                    {
                        System.out.println("oops");
                        if (heath <= totalHeath/4)
                        {
                        heath = totalHeath/4;
                        System.out.println("Heath is: " + heath);
                        }
                        if (heath > totalHeath/4)
                        {
                        heath = heath;
                        System.out.println("Heath is: " + heath);
                        }
                    }
                    if (randomHeathing <= 8 && randomHeathing > 6)
                    {
                        System.out.println("oops");
                        if (heath <= totalHeath/4)
                        {
                        heath = totalHeath/4;
                        System.out.println("Heath is: " + heath);
                        }
                        if (heath > totalHeath/4)
                        {
                        heath = heath;
                        System.out.println("Heath is: " + heath);
                        }
                    }
                    if (randomHeathing <= 10 && randomHeathing > 8)
                    {
                        System.out.println("nevermind have a pot");
                        heath = heath + 50;
                        System.out.println("Heath is: " + heath);
                        
                    }
                    if (randomHeathing > 10)
                    {
                        System.out.println("oh no oh no");
                        heath = heath /2;
                        System.out.println("Heath is: " + heath);
                        System.out.println("im so sorry");
                        
                    }
                    
                    
                }
            }
            
            
            
            if (roll == 2)
            {
                String monsterName = getMonsterName(1);
                System.out.println("Hello Adventurer,");
                System.out.println("My name, is " + monsterName);
                System.out.println("Would like to open me?");
                String open = keyboard.nextLine();
                System.out.println("*you open " + monsterName + "*");
                int monsterLevel = rand.nextInt(6) + 1;
                monsterLoot = getLootTable(monsterLevel);
            }
            if (roll >= 7)
            {
               
                
                    int monsterHeath = 400*monsterUpgrade;
                    int monsterDamage = 40*monsterUpgrade;
                    int monsterLevel = 100;
                    System.out.println("Random Demon Has Appeard");
                    System.out.println("Prepare to die mortal!");
                    double fight = getFightMode(monsterHeath, attack, heath, monsterDamage, monsterLevel, armour);
                      if (fight <= 0)
                    {
                        end = 1;
                        System.out.println("You died!");
                    }
                    if (fight > 0)
                    {
                        end = 0;
                        System.out.println("You have defected the monster!");
                        heath = fight;
                        monsterLoot = getLootTable(monsterLevel);
                    }
                    floorLevel++;
                    monsterUpgrade = monsterUpgrade + 1;
                    System.out.println("You wont escape!");
                    exp = exp + 400;
                    System.out.println("You now have " + exp + " exp");
                    
                }
            
        }
        
    }
    
   public static int getDiceRoll(int rollDice)
   {
       Random rand= new Random();
       int  randomDice = rand.nextInt(rollDice) + 1;
       return randomDice;
   }
   public static double getFightMode(int monsterHeath, int a, double h, int m, int l,int am)
   {    
                    while (monsterHeath > 0)
                    {
                    if (h < 0)
                        monsterHeath = 0;
                    System.out.println("Heath " + h);
                    System.out.println("Monster Heath " + monsterHeath);
                    Scanner keyboard = new Scanner (System.in);
                    Random rand= new Random();
                    int choice =0;
                    System.out.printf("What are you going to do?%n(1 = Attack,"
                            + "2 = Defence, 3 = Run)%n");
                    choice = keyboard.nextInt();
                    System.out.println("");
                    System.out.println("");
                    if (choice == 1)
                    {
                       int randomAttack = rand.nextInt(a); 
                       monsterHeath = monsterHeath - randomAttack;
                       int randomMobAttack = rand.nextInt(m);
                       if (am > randomMobAttack)
                              randomMobAttack = 0;
                       if (am <= randomMobAttack)
                              randomMobAttack = randomMobAttack - am;
                       h = h - randomMobAttack;
                       System.out.println("You have dealt " +randomAttack+" damage and revieved " + randomMobAttack+ " and blocked " + am);
                    }
                    if (choice == 2)
                    {
                       double randomBlock = rand.nextInt(6) + 1;
                       double randomAttack = rand.nextInt(m) + 1;
                       System.out.println("You rolled a " + randomBlock);
                       if (randomBlock == 1)
                       {
                       System.out.printf("You dodge the attack%n");
                       }
                       if (randomBlock == 2)
                       {
                       if (am > randomAttack)
                              randomAttack = 0;
                       if (am <= randomAttack)
                              randomAttack = randomAttack - am;          
                       System.out.printf("You block some of the attack reciving %f%n",randomAttack/2);
                       h = h - randomAttack/2;
                       }
                       if (randomBlock == 3)
                       {
                           int randomParry = rand.nextInt(a); 
                           monsterHeath = monsterHeath - randomParry;
                           System.out.println("You parry the attack and deal " + randomParry+ " damage!");
                       }
                       if (randomBlock == 4)
                       {
                          if (am > randomAttack)
                              randomAttack = 0;
                          if (am <= randomAttack)
                              randomAttack = randomAttack - am;   
                          h = h - randomAttack/2;
                           System.out.printf("You block some of the attack reciving %f%n",randomAttack/2);
                       }
                       if (randomBlock == 5)
                       {
                          if (am > randomAttack)
                              randomAttack = 0;
                          if (am <= randomAttack)
                              randomAttack = randomAttack - am;
                          h = h - randomAttack;
                          System.out.printf("You recive %f damage%n",randomAttack);
                       }
                       if (randomBlock == 6)
                       {
                          if (am > randomAttack)
                              randomAttack = 0;
                          if (am <= randomAttack)
                              randomAttack = randomAttack - am;
                          h = h - randomAttack;
                          System.out.printf("You recive %f damage%n",randomAttack);
                       }
                    }
                    if (choice == 3)
                    {
                        if (l != 100)
                        {
                            int randomRun = rand.nextInt(5) + 1;
                            if (randomRun == 1)
                            {
                                monsterHeath = 0;
                                System.out.println("You run away");

                            }
                            if (randomRun >= 2)
                            {
                                int randomAttack = rand.nextInt(m); 
                                if (am > randomAttack)
                                    randomAttack = 0;
                                if (am <= randomAttack)
                                    randomAttack = randomAttack - am;
                                System.out.println("You recive" + randomAttack + " attack!");
                                h = h - randomAttack; 
                            }
                        }
                        if (l == 100)
                        {
                           System.out.println("You can not run from me!");
                           int randomAttack = rand.nextInt(m);
                           if (am > randomAttack)
                              randomAttack = 0;
                           if (am <= randomAttack)
                              randomAttack = randomAttack - am;
                           System.out.println("You recive" + randomAttack + " attack!");
                           h = h - randomAttack;
                        }
                    }
                    else
                        System.out.println("Wrong key!");
                    
                    }
                    return h;
   }
   public static int getBuy(int itemprice, int gp, int buying)
   {    
       if (itemprice <= gp)
       {
           buying = 2;
       }
       if (itemprice > gp)
       {
           buying = 1;
           System.out.println("You dont have the money for that!");
           System.out.println("Check again!");
           System.out.println("You have " + gp + "coins");
       }
       return buying;
   }
   
   
   
   public static int getLootTable(int monsterDrop)
   {
   
       Random rand= new Random();
       int randomloot = rand.nextInt(100) + 1;
       int loot = 0;
       if (monsterDrop == 1)
           {
            if (randomloot <= 25)
            {
                System.out.println("You have recived a heath pot!");
                loot = 1;
            }
            if (randomloot >= 26 && randomloot <= 50)
            {
                System.out.println("You have recived a Jelly Sword!");
                loot = 2;
            }
            if (randomloot >= 51 && randomloot <= 75)
            {
                System.out.println("You have recived a Basic Armour!");
                loot = 4;
            }
            if (randomloot >= 76)
            {
                System.out.println("You have recived a 20 gp!");
                loot = 16;
            }
           }
           if (monsterDrop == 2)
           {
            if (randomloot >= 0 && randomloot <= 40)
            {
                System.out.println("You have recived a heath pot!");
                loot = 1;
            }
            if (randomloot >= 41 && randomloot <= 50)
            {
                System.out.println("You have recived a Bandit Sword!");
                loot = 10;
            }
            if (randomloot >= 51 && randomloot <= 60)
            {
                System.out.println("You have recived Boots!");
                loot = 5;
            }
            if (randomloot >= 61)
            {
                System.out.println("You have recived a 50 gp!");
                loot = 17;
            }
           }
           if (monsterDrop == 3)
           {
            if (randomloot >= 0 && randomloot <= 25)
            {
                System.out.println("You have recived a heath pot!");
                loot = 1;
            }
            if (randomloot >= 26 && randomloot <= 50)
            {
                System.out.println("You have recived a Goblin Spear!");
                loot = 11;
            }
            if (randomloot >= 51 && randomloot <= 75)
            {
                System.out.println("You have recived none!");
                loot = 0;
            }
            if (randomloot >= 76)
            {
                System.out.println("You have recived a 5 gp!");
                loot = 18;
            }
           }
           if (monsterDrop == 4)
           {
            if (randomloot >= 0 && randomloot <= 35)
            {
                System.out.println("You have recived a 3 heath pot!");
                loot = 3;
            }
            if (randomloot >= 36 && randomloot <= 56)
            {
                System.out.println("You have recived a Heavy tshirt!");
                loot = 7;
            }
            if (randomloot >= 57 && randomloot <= 60)
            {
                System.out.println("You have recived a left arm!");
                loot = 12;
            }
            if  (randomloot >= 61)
            {
                System.out.println("You have recived a 40 gp!");
                loot = 18;
            }
           }
          if (monsterDrop == 5)
          {
            if (randomloot >= 0 && randomloot <= 10)
            {
                System.out.println("You have recived a Knight Helmet!");
                loot = 8;
            }
            if (randomloot >= 11 && randomloot <= 20)
            {
                System.out.println("You have recived a Knight Sword!");
                loot = 13;
            }
            if (randomloot >= 21 && randomloot <= 25)
            {
                System.out.println("You have recived a Knight Chestplate!");
                loot = 9;
            }
            if (randomloot >= 26)
            {
                System.out.println("You have recived a 50 gp!");
                loot = 17;
            }
          }
            if (monsterDrop == 6)
          {
            if (randomloot >= 0 && randomloot <= 40)
            {
                System.out.println("You have recived a heath pot!");
                loot = 1;
            }
            if (randomloot >= 41 && randomloot <= 80)
            {
                System.out.println("You have recived a lava bucket!");
                System.out.println("Sadly you cant use that!");
                loot = 14;
            }
            if (randomloot >= 81 && randomloot <= 95)
            {
                System.out.println("You have recived a Hammer!");
                loot = 15;
            }
            if (randomloot >= 96)
            {
                System.out.println("You have recived a 75 gp!");
                loot = 20;
            }
          }
          if (monsterDrop == 100)
          {
            if (randomloot >= 0 && randomloot <= 2)
            {
                System.out.println("You have recived a Demon Blade!");
                
                loot = 16;
            }
            if (randomloot >= 3 && randomloot <= 4)
            {
                System.out.println("Demon Thorn Armour!");
                loot = 9;
            }
            if (randomloot >= 44)
            {
                System.out.println("You have recived a nothing");
                loot = 0;
            }
            if (randomloot >= 29 && randomloot <= 44)
            {
                System.out.println("You have recived a 100 gp!");
                loot = 21;
            }
          }
        
        return loot;
   } 
   public static String getMonsterName(int monsterN)
   {
       Random rand= new Random();
       String mobName = "";
       int  randomDice = rand.nextInt(5) + 1;
       if (monsterN == 1)
            if (randomDice == 1)
                mobName = "Cheslyn";
            if (randomDice == 2)
                mobName = "Chester";
            if (randomDice == 3)
                mobName = "Sir Chesterton";
            if (randomDice == 4)
                mobName = "Bob....";
            if (randomDice == 5)
                mobName = "S's Chest";
        return mobName;
   }
   public static int getHeathBonus(int monsterDropHeath)
   {
       int bonus = 0;
       if (monsterDropHeath == 1)
           bonus = 10;
       if (monsterDropHeath == 3)
           bonus = 30;
       if (monsterDropHeath == 2)
           bonus = 15;
       System.out.println("Heath drop bonus is +" + bonus);
       return bonus;
           
   }
    public static int getAttackBonus(int monsterDropAttack)
   {
       int bonus = 0;
       if (monsterDropAttack == 10)
           bonus = 3;
       if (monsterDropAttack == 11)
           bonus = 2;
       if (monsterDropAttack == 12)
           bonus = 3;
       if (monsterDropAttack == 13)
           bonus = 5;
       if (monsterDropAttack == 14)
           bonus = 0;
       if (monsterDropAttack == 15)
           bonus = 4;
       if (monsterDropAttack == 16)
           bonus = 7;
       System.out.println("Attack drop bonus is +" + bonus);
       return bonus;
           
   }
   public static int getDefenceBonus(int monsterDropDefence)
   {
       int bonus = 0;
       if (monsterDropDefence == 4)
           bonus = 2;
       if (monsterDropDefence == 5)
           bonus = 1;
       if (monsterDropDefence == 6)
           bonus = 2;
       if (monsterDropDefence == 7)
           bonus = 4;
       if (monsterDropDefence == 8)
           bonus = 6;
       if (monsterDropDefence == 9)
           bonus = 9;
       System.out.println("Defence drop bonus is +" + bonus);
       return bonus;
           
   }
   public static int getCoinBonus(int monsterDropCoins)
   {
       int bonus = 0;
       if (monsterDropCoins == 16)
           bonus = 20;
       if (monsterDropCoins == 17)
           bonus = 50;
       if (monsterDropCoins == 18)
           bonus = 5;
       if (monsterDropCoins == 19)
           bonus = 40;
       if (monsterDropCoins == 20)
           bonus = 75;
       if (monsterDropCoins == 21)
           bonus = 100;
       System.out.println("Coins drop bonus is +" + bonus);
       return bonus;
           
   }
   public static int getShop(int shoptype)
   {
       int shopstat = 0;
       if (shoptype == 1)
       {
           System.out.println("Hey Welcome");
           System.out.println("Im Ron the Armour Smith");
           System.out.println("What can I do for ya");
           shopstat = 2;
       }
       if (shoptype == 2)
       {
           System.out.println("Hey Warrior");
           System.out.println("Im Sarah the Armour Smith");
           System.out.println("What you need sweetie");
           shopstat = 2;
       }
       if (shoptype == 3)
       {
           System.out.println("Whoa watch your step didnt know i was having vistors");
           System.out.println("Im Steven the Weapon Smith");
           System.out.println("Please take a look around");
           shopstat = 3;
       }
       if (shoptype == 4)
       {
           System.out.println("Is that a sword in your pocket or are you happy to see me");
           System.out.println("Im Auroa the Weapom Smith");
           System.out.println("Hope everything is to your liking");
           shopstat = 3;
       }
       if (shoptype == 5)
       {
           System.out.println("Go away");
           System.out.println("Im James the owner of this blackmarket");
           System.out.println("What do you want");
           shopstat = 4;
       }
       if (shoptype == 6)
       {
           System.out.println("I like you");
           System.out.println("Buy what you like, we have everything you want");
           System.out.println("Come on grab it");
           shopstat = 4;
       }
       if (shoptype == 7)
       {
           System.out.println("Welcome to the general store");
           System.out.println("Im Edwardo the Merchant");
           System.out.println("Hope I got the things you need");
           shopstat = 1;
       }
       if (shoptype == 8)
       {
           System.out.println("Hey you");
           System.out.println("Emily is the name, all powerful merchant");
           System.out.println("You wont find better stuff then here trust me");
           shopstat = 1;
       }
       if (shoptype == 9)
       {
           System.out.println("Hello, we havent seen any customers in forever");
           System.out.println("Im Zack and Im Mary");
           System.out.println("Please take a look around");
           shopstat = 1;
       }
       if (shoptype == 10)
       {
           System.out.println("Hey, I am Emilia");
           System.out.println("I havent seen anyone like you in forever, every sence... nevermind");
           System.out.println("What you like some heathing");
           shopstat = 5;
       }
       
       return shopstat;
   }
  
    
}

