/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgottengame;

//import javafx.scene.control.Button;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Formatter;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author williammc
 */
public class ForgottenMazeLayoutController implements Initializable {
    
    //this is the monster drop lootTable
    //loot name, lootBonus, lootType, lootCode
    // type = 1 heath, 2 coins, 3 attack, 4 armour
    LootTable HeathPot = new LootTable ("Heath pot", 10 , 1 ,1);
    LootTable HeathPotThree = new LootTable ("Three Heath pot", 30 , 1 ,2);
    LootTable HeathPotFive = new LootTable ("Five Heath pot", 50 , 1 ,3);
    LootTable FiveCoins = new LootTable ("Five Coins", 5 , 2 , 4);
    LootTable TwentyCoins = new LootTable ("20 Coins", 20 , 2 , 5);
    LootTable FortyCoins = new LootTable ("40 Coins", 40 , 2 , 6);
    LootTable FiftyCoins = new LootTable ("50 Coins", 50 , 2 , 7);
    LootTable SeventyFiveCoins = new LootTable ("75 Coins", 75 , 2 , 8);
    LootTable HundredFiveCoins = new LootTable ("100 Coins", 100 , 2 , 9);
    LootTable ThornArmour = new LootTable ("Thorn Armour", 9 , 4 , 10);
    LootTable Boots = new LootTable ("Boots", 1 , 4 , 11);
    LootTable BasicArmour = new LootTable ("Basic Armour", 2 , 4 , 12);
    LootTable HeavyShirt = new LootTable ("Heavy Shirt", 1 , 4 , 13);
    LootTable KnightHelmet = new LootTable ("Knights Helmet", 4 , 4 , 14);
    LootTable KnightChestPlate = new LootTable ("Knights Chestplate", 6 , 4 , 15);
    LootTable DemonBlade = new LootTable ("Demon Blade", 7 , 3 , 16);
    LootTable LeftArm = new LootTable ("Left Arm", 2 , 3 , 17);
    LootTable Dagger = new LootTable ("Dagger", 4 , 3 , 18);
    LootTable Spear = new LootTable ("Goblin Spear", 3 , 3 , 19);
    LootTable KnightSword = new LootTable ("Knight Sword", 5 , 3 , 20);
    LootTable Hammer = new LootTable ("Hammer", 4 , 3 , 21);
    

   //Types of monsters images 
    Image goblinImage = new Image ("goblin.jpg");
    Image banditImage = new Image ("bandit.png");
    Image knightImage = new Image ("knight.jpeg");
    Image slimeImage = new Image ("slime.png");
    Image dwarfImage = new Image ("dwarf.png");
    Image zombieImage = new Image ("zombie.png");
    Image demonImage = new Image ("demon.png");
    Image shopImage = new Image ("shop.jpg");
    Image chestImage = new Image ("chest.jpg");
    Image fairyImage = new Image ("fairy.jpg");
    
    //monster stats heath, attack, level, image, exp
    Monsters Goblin = new Monsters ("Goblin", 40, 11, 3, goblinImage, 50);
    Monsters Bandit = new Monsters ("Bandit", 60, 16, 2, banditImage, 100);
    Monsters Knight = new Monsters ("Knight", 220, 20, 5, knightImage, 150);
    Monsters Slime = new Monsters ("Slime", 40, 10, 1, slimeImage, 25);
    Monsters Dwarf = new Monsters ("Dwarf", 120, 10, 6, dwarfImage, 100);
    Monsters Zombie = new Monsters ("Zombie", 400, 5, 4, zombieImage, 100);
    Monsters Demon = new Monsters ("Demon", 450, 40, 100, demonImage, 225);
    
    
    // player Stats at the begining of the game
    // player stats goes as follow name coins attack armour heath    
    PlayerStats Squire = new PlayerStats("Squire", 10, 20, 2, 150);
    PlayerStats Merchant = new PlayerStats("Merchant", 200, 10, 0, 100);
    PlayerStats Assassin = new PlayerStats("Assassin", 50, 50, 0, 50);
    PlayerStats Berserker = new PlayerStats("Berserker", 0, 25, 0, 250);
    PlayerStats Warrior = new PlayerStats("Knight", 50, 25, 5, 200);
    
    //Shopitems 
    // goes items name, price, bonis and bonusType 1 = attack, 
    // 2 = Armour, 3 = heath
    MarketTypes heathPots = new MarketTypes ("HeathPots",10, 10, 3);
    MarketTypes strongSword = new MarketTypes ("Strong Sword",100, 4, 1);
    MarketTypes strongArmour = new MarketTypes ("Strong Armour",100, 2, 2);
    
    MarketTypes basicHelmet = new MarketTypes ("Helmet ",40, 1, 2);
    MarketTypes steelLegs = new MarketTypes ("Steel PlateLegs ",100, 3, 2);
    MarketTypes steelBody = new MarketTypes ("Steel Platebody ",120, 5, 2);
    
    MarketTypes kitchenKnife = new MarketTypes ("kitch Knife ",40, 1, 1);
    MarketTypes steelSword = new MarketTypes ("Steel Sword ",120, 6, 1);
    MarketTypes steelBroadSword = new MarketTypes ("Steel BroadSword ",160, 7, 1);
    
    MarketTypes superPots = new MarketTypes ("SuperPots",225, 200, 3);
    MarketTypes jugernautArmour = new MarketTypes ("Jugernaut Armour",350, 10, 2);
    MarketTypes steelLance = new MarketTypes ("Steel Lance",250, 12, 1);
    
            
    
    //background that doesnt change
    @FXML private Label FloorMainLabel;
    
    //background lavel that does change 
    @FXML private Label FloorLabel;
    @FXML private Label BeginLabel;
    
    //npc labels that dont change 
    //@FXML private Label MonsterHeathMainLabel;
    //@FXML private Label MonsterLevelMainLabel;
    
    //Npc labels that change 
    @FXML private Label MonsterHeathLabel;
    @FXML private Label MonsterAttackLabel;
    @FXML private Label MonsterNameLabel;
    @FXML private Label MonsterHeathMainLabel;
    @FXML private Label MonsterAttackMainLabel;
    @FXML private ImageView NpcImage;
    
    //ShopLabels 
    @FXML private Label ShopButtonOneLabel;
    @FXML private Label ShopButtonTwoLabel;
    @FXML private Label ShopButtonThreeLabel;
    
    //player labels that dont change 
    @FXML private Label PlayerHeathMainLabel; 
    @FXML private Label PlayerAttackMainLabel;
    @FXML private Label PlayerAmourMainLabel;
    @FXML private Label PlayerCoinsMainLabel;
    @FXML private Label PlayerLevelMainLabel;
    
    //player labels that change 
    @FXML private Label PlayerHeathLabel; 
    @FXML private Label PlayerAttackLabel;
    @FXML private Label PlayerAmourLabel;
    @FXML private Label PlayerCoinsLabel;
    @FXML private Label PlayerLevelLabel;
    
    //player stats radioButtons
    @FXML private RadioButton AssassinRadioButton;
    @FXML private RadioButton KnightRadioButton;
    @FXML private RadioButton MerchantRadioButton;
    @FXML private RadioButton SquireRadioButton;
    @FXML private RadioButton BerskerRadioButton;
    
    
    //Action buttons 
    @FXML private Button AttackButton;
    @FXML private Button DefendButton;
    @FXML private Button RunButton;
    @FXML private Button LeaveButton;
    @FXML private Button BeginButton;
    
 
    
    //Chat logs 
    @FXML private TextArea MainChatText; 
    @FXML private TextArea CombatChatText;
    @FXML private TextArea StoryChatText;
    //Monster inputs 
    String mainChat = "";
    String combatChat = "";
    int monsterAttack = 10;
    double monsterHeath = 100;
    String monsterName = "";
    int LevelUpMax = 1000;
    int LevelUp = 0;
    int monsterExp = 0;
    int monsterLevel = 0;
    
    
    //@FXML private Image NPCImage;
    
    //player inputs
    int playerAttack = 10;
    double playerHeath = 100;
    int playerCoins = 50;
    int playerArmour = 0;
    int playerLevel = 1;
    double intialPlayerHeath = 0;
    int armourBreak = 0;
    int armourBreakDamage = 0;
    String storyChat="";
    
    
    //when the shop equals false it means that the player is fighting a monster
    //when shop = true that means the the player is in a shop
    boolean shop = false;
    int shopType = 0;
    
    //background input
    int floorLevel = 1;
    Random rand= new Random();
    //To make sure the user cant select more then one class
    private ToggleGroup classButtonToggle;
    
    public void radioButtonChanged(){
        if (classButtonToggle.getSelectedToggle().equals(AssassinRadioButton))
        {
          playerAttack = Assassin.getPlayerAttack();
          playerHeath = Assassin.getPlayerHeath();
          playerCoins = Assassin.getPlayerCoins();
          playerArmour = Assassin.getPlayerAmour();
          storyChat = "One of the most well known assassins, you killed your enemies without a sound." 
                  + System.lineSeparator() 
                  + "Your master respected you as a warrior, many feared you"
                  + System.lineSeparator() 
                  + "Until the day you were tasked to kill your own master"
                  + System.lineSeparator()
                  + "So what did you do?"
                  + System.lineSeparator()
                  + "You killed him, you killed your only master"
                  + System.lineSeparator()
                  + "You were captured and beaten"
                  + System.lineSeparator()
                  + "You are alone without a home and a master, you are unless to me";
                  
        }
          
        if (classButtonToggle.getSelectedToggle().equals(KnightRadioButton))
        {
          playerAttack = Warrior.getPlayerAttack();
          playerHeath = Warrior.getPlayerHeath();
          playerCoins = Warrior.getPlayerCoins();
          playerArmour = Warrior.getPlayerAmour();
          storyChat = "Known as a conquer, you killed with strength and respect." 
                  + System.lineSeparator() 
                  + "Your king respected you and gave you things many men could only dream of"
                  + System.lineSeparator() 
                  + "But even after all the richs your king gave you, you wanted more"
                  + System.lineSeparator()
                  + "So what did you do?"
                  + System.lineSeparator()
                  + "You killed the kings men a stole the kings riches and queen"
                  + System.lineSeparator()
                  + "You created a group of bandits and killers stealing from the rich and killing the poor"
                  + System.lineSeparator()
                  + "But that didnt last long, because your own men has the same greed as you and descide they didnt need you"
                  + System.lineSeparator()
                   + "No money or queen you are left alone here, you have noone to protect you here knight";
                          
        }
          
        if (classButtonToggle.getSelectedToggle().equals(MerchantRadioButton))
        {
          playerAttack = Merchant.getPlayerAttack();
          playerHeath = Merchant.getPlayerHeath();
          playerCoins = Merchant.getPlayerCoins();
          playerArmour = Merchant.getPlayerAmour();
          storyChat = "Known as the merchant of camlot, you had many riches and land." 
                  + System.lineSeparator() 
                  + "Kings invited you to their kingdoms for your wares"
                  + System.lineSeparator() 
                  + "But you got greedy didnt you?"
                  + System.lineSeparator()
                  + "So what did you do?"
                  + System.lineSeparator()
                  + "You began to scam anyone and everyone lying to any man regardless of rank"
                  + System.lineSeparator()
                  + "You got caught though chased out of all of the kingdoms you kept foot in"
                  + System.lineSeparator()
                  + "Known as the sinful merchant, you ran and took what remains of your riches away"
                  + System.lineSeparator()
                   + "But that didnt stop the dogs in the forest now did it, Your riches wont buy you freedom here";
          
        }
        
        if (classButtonToggle.getSelectedToggle().equals(SquireRadioButton))
        {
          playerAttack = Squire.getPlayerAttack();
          playerHeath = Squire.getPlayerHeath();
          playerCoins = Squire.getPlayerCoins();
          playerArmour = Squire.getPlayerAmour();
          storyChat = "Known as a follower, you supported your knight with honour." 
                  + System.lineSeparator() 
                  + "You were the most skilled you your rank"
                  + System.lineSeparator() 
                  + "Thinking you would become a knight soon"
                  + System.lineSeparator()
                  + "Until your knight was killed in battle beside you"
                  + System.lineSeparator()
                  + "The king ignored you and knighted someone else"
                  + System.lineSeparator()
                  + "So what did you do?"
                  + System.lineSeparator()
                  + "Jealous you killed the new found knight in his sleep, and was captured by your own king"
                  + System.lineSeparator()
                  + "There is no knight to protect you here this is your jail now";
        }
        
        if (classButtonToggle.getSelectedToggle().equals(BerskerRadioButton))
        {
          playerAttack = Berserker.getPlayerAttack();
          playerHeath = Berserker.getPlayerHeath();
          playerCoins = Berserker.getPlayerCoins();
          playerArmour = Berserker.getPlayerAmour();
          storyChat = "Known as a reaper, you killed many knights and men." 
                  + System.lineSeparator() 
                  + "Your men feared you, you burned down villages and kingdoms you your path"
                  + System.lineSeparator() 
                  + "Until you met an unstoppable force"
                  + System.lineSeparator()
                  + "So what did you do?"
                  + System.lineSeparator()
                  + "You charged straight into the battlefeild killing so many men"
                  + System.lineSeparator()
                  + "I honour your stupidity berserker but really I do not care about how many men you killed that day"
                  + System.lineSeparator()
                  + "You are a rat on this battlefeild useless and forgotten"
                  + System.lineSeparator()
                   + "This place is your final battlefeild";
        }
        StoryChatText.setText(storyChat);
              
        
            
    }
    public void StartButtonPushed(){
        BeginButton.setVisible(false);
        BeginLabel.setVisible(false);
        AssassinRadioButton.setVisible(false);
        KnightRadioButton.setVisible(false);
        MerchantRadioButton.setVisible(false);
        SquireRadioButton.setVisible(false);
        BerskerRadioButton.setVisible(false);
        StoryChatText.setVisible(false);
        
        
        CombatChatText.setVisible(true);
        MainChatText.setVisible(true);
        
        PlayerHeathMainLabel.setVisible(true);
        PlayerAttackMainLabel.setVisible(true);
        PlayerAmourMainLabel.setVisible(true);
        PlayerCoinsMainLabel.setVisible(true);
        PlayerLevelMainLabel.setVisible(true);
        
        PlayerHeathLabel.setVisible(true);
        PlayerAttackLabel.setVisible(true);
        PlayerCoinsLabel.setVisible(true);
        PlayerLevelLabel.setVisible(true);
        PlayerAmourLabel.setVisible(true);
        
         AttackButton.setVisible(true);
         DefendButton.setVisible(true);
         RunButton.setVisible(true);
         LeaveButton.setVisible(true);
         
         FloorMainLabel.setVisible(true);
         FloorLabel.setVisible(true);
        
        String playerAttackString = String.format("%d", playerAttack );
        String playerCoinsString = String.format("%d", playerCoins );
        String playerArmourString = String.format("%d", playerArmour );
        String playerHeathString = String.format("%.2f", playerHeath ); 
        
        PlayerHeathLabel.setText(playerHeathString);
        PlayerAttackLabel.setText(playerAttackString);
        PlayerCoinsLabel.setText(playerCoinsString);
        PlayerAmourLabel.setText(playerArmourString);
        intialPlayerHeath = playerHeath;
        RunGame();
    }
   public void RunGame(){
       int incounter = DiceRoll(4);
       String playerLevelString = String.format("%d", playerLevel );
       PlayerLevelLabel.setText(playerLevelString);
       String floorLevelString = String.format("%d", floorLevel );
       FloorLabel.setText(floorLevelString);
       String playerArmourString = String.format("%d", playerArmour );
       PlayerAmourLabel.setText(playerArmourString); 
       String playerCoinsString = String.format("%d", playerCoins );
       PlayerCoinsLabel.setText(playerCoinsString);
       
       if (playerArmour >= 2 && armourBreak == 6){
           int playerArmourBreaking = playerArmour;
           armourBreakDamage = DiceRoll(playerArmourBreaking);
           playerArmour = playerArmour -  armourBreakDamage;
           armourBreak = 0;
       }
       
       
       
           armourBreak++;
           combatChat = "Your armour begins to wear";
           System.out.print(armourBreak);
       
       CombatChatText.setText(combatChat);
       if (incounter == 1)
       
       {
            shop = true;
            AttackButton.setVisible(true);
            DefendButton.setVisible(true);
            RunButton.setVisible(true);
            AttackButton.setText("Buy");
            DefendButton.setText("Buy");
            RunButton.setText("Buy");
            ShopButtonOneLabel.setVisible(true);
            ShopButtonTwoLabel.setVisible(true);
            ShopButtonThreeLabel.setVisible(true);
            MonsterAttackLabel.setVisible(false);
            MonsterHeathLabel.setVisible(false);
            MonsterAttackMainLabel.setVisible(false);
            MonsterHeathMainLabel.setVisible(false);
            MonsterNameLabel.setVisible(true);
            //picks the shop that will appear
           int shopIncounter = DiceRoll(100);
           if (shopIncounter <= 35)
           {
               GeneralStore();
           }
           if (shopIncounter > 35 && shopIncounter <= 50)
           {
               BlackMarket();
           }
           if (shopIncounter > 50 && shopIncounter <= 70)
           {
               AmourSmith();
           }
           if (shopIncounter > 70 && shopIncounter <= 90)
           {
               WeaponSmith();
           }
           if (shopIncounter > 90 && shopIncounter <= 95)
           {
               FairyShop();
           }
           if (shopIncounter > 95 && shopIncounter <= 100)
           {
               ChestShop();
           }
       }
       if (incounter >= 2)
       {
            shop = false;
            AttackButton.setVisible(true);
            DefendButton.setVisible(true);
            RunButton.setVisible(true);
            AttackButton.setText("Attack");
            DefendButton.setText("Defend");
            RunButton.setText("Run");
            ShopButtonOneLabel.setVisible(false);
            ShopButtonTwoLabel.setVisible(false);
            ShopButtonThreeLabel.setVisible(false);
            MonsterAttackLabel.setVisible(true);
            MonsterHeathLabel.setVisible(true);
            MonsterNameLabel.setVisible(true);
            MonsterAttackMainLabel.setVisible(true);
            MonsterHeathMainLabel.setVisible(true);
            spawnMonster();
       }
      
  }
    
    public void AttackButtonPushed() throws FileNotFoundException{
        
        if (shop == false)
        {
        int randomAttack = rand.nextInt(playerAttack); 
        monsterHeath = monsterHeath - randomAttack;
        mainChat = mainChat + "Damage Dealt: " + randomAttack + System.lineSeparator();
        combatChat = "Damage Dealt: " + randomAttack;
        
        int randomMobAttack = rand.nextInt(monsterAttack);
        if (playerArmour > randomMobAttack)
        {
            randomMobAttack = 0;
            mainChat = mainChat + "Damage Taken: " + randomMobAttack + System.lineSeparator();
        }
        if (playerArmour <= randomMobAttack)
        {
            randomMobAttack = randomMobAttack - playerArmour;
            mainChat = mainChat + "Damage Taken: " + randomMobAttack + System.lineSeparator();
            playerHeath = playerHeath - randomMobAttack;
        }
        if (playerHeath <= 0)
        {
            Death();
        }
        if (monsterHeath <= 0)
        {
            if (monsterLevel == 100){
                floorLevel++;
            }
            LevelUp(monsterExp);
        }
        String floorString = String.format("%d", floorLevel );
        String monsterHeathString = String.format("%.2f", monsterHeath );
        String playerHeathString = String.format("%.2f", playerHeath );
       CombatChatText.setText(combatChat);
       MainChatText.setText(mainChat);
       
       PlayerHeathLabel.setText(playerHeathString);
       MonsterHeathLabel.setText(monsterHeathString);
       FloorLabel.setText(floorString);
    }
        if(shop == true)
        {
            if (shopType == 2)
            {
                int healingChance = DiceRoll(10);
                if (healingChance <= 2)
                {
                    playerHeath = intialPlayerHeath;
                    mainChat = mainChat + "Look at that good as new "+ System.lineSeparator();
                }
                if (healingChance >= 8)
                {
                    playerHeath = playerHeath/2;
                    mainChat = mainChat + "Oh no Oh no im so sorry "+ System.lineSeparator();
                }
                if (healingChance > 2 && healingChance < 8)
                {
                    playerHeath = playerHeath + 75;
                    intialPlayerHeath = intialPlayerHeath + 75;
                    mainChat = mainChat + "I did something... Yah! "+ System.lineSeparator();
                }
                RunGame();
            }
            
            if (shopType == 3)
            {
               CheckPrice(heathPots.getPriceOfItem(), heathPots.getBonusType(), heathPots.getItemStatBonus());
            }
            if (shopType == 4)
            {
                CheckPrice(kitchenKnife.getPriceOfItem(), kitchenKnife.getBonusType(), kitchenKnife.getItemStatBonus());
            }
            if (shopType == 5)
            {
                CheckPrice(basicHelmet.getPriceOfItem(), basicHelmet.getBonusType(), basicHelmet.getItemStatBonus());
            }
            if (shopType == 6)
            {
                CheckPrice(superPots.getPriceOfItem(), superPots.getBonusType(), superPots.getItemStatBonus());
            }
                
        }
    }
    public void DefendButtonPushed() throws FileNotFoundException{
        if (shop == false)
        {
        double randomBlock = rand.nextInt(6) + 1;
                       double randomAttack = rand.nextInt(monsterAttack) + 1;
                       System.out.println("You rolled a " + randomBlock);
                       if (randomBlock == 1)
                       {
                       CombatChatText.setText("You dodge the attack");
                       }
                       if (randomBlock == 2)
                       {
                       if (playerArmour > randomAttack)
                              randomAttack = 0;
                       if (playerArmour <= randomAttack)
                              randomAttack = randomAttack - playerArmour;
                       CombatChatText.setText("You block some of the attack reciving" + randomAttack/2);
                       mainChat = mainChat + "Damage Taken:"+ randomAttack/2 + System.lineSeparator();
                
                       playerHeath = playerHeath - randomAttack/2;
                       
                       if (randomBlock == 3)
                       {
                           int randomParry = rand.nextInt(playerAttack); 
                           monsterHeath = monsterHeath - randomParry;
                           CombatChatText.setText("You parry the attack and deal " + randomParry+ " damage!");
                           mainChat = mainChat + "Damage Dealt "+ randomParry + System.lineSeparator();
             
                       }
                       if (randomBlock == 4)
                       {
                          if (playerArmour > randomAttack)
                              randomAttack = 0;
                          if (playerArmour <= randomAttack)
                              randomAttack = randomAttack - playerArmour;
                          
                          playerHeath = playerHeath - randomAttack/2;
                          CombatChatText.setText("You block some of the attack reciving" + randomAttack/2);
                          mainChat = mainChat + "Damage Taken:"+  randomAttack/2 + System.lineSeparator();
                
                       }
                       if (randomBlock == 5)
                       {
                          if (playerArmour > randomAttack)
                              randomAttack = 0;
                          if (playerArmour <= randomAttack)
                              randomAttack = randomAttack - playerArmour;
                          playerHeath = playerHeath - randomAttack;
                          CombatChatText.setText("You recived" + randomAttack + "damage");
                          mainChat = mainChat + "Damage Taken:" + randomAttack + System.lineSeparator();
              
                       }
                       if (randomBlock == 6)
                       {
                          if (playerArmour > randomAttack)
                              randomAttack = 0;
                          if (playerArmour <= randomAttack)
                              randomAttack = randomAttack - playerArmour;
                          playerHeath = playerHeath - randomAttack;
                          CombatChatText.setText("You recived" + randomAttack + "damage");
                          mainChat = mainChat + "Damage Taken:"+ randomAttack + System.lineSeparator();
                       }
                       if (playerHeath <= 0)
                        {
                        Death();
                        }
                        if (monsterHeath <= 0)
                        {
                         if (monsterLevel == 100)
                         {
                             floorLevel++;
                         }
                         LevelUp(monsterExp);
                        }
                       
       String monsterHeathString = String.format("%.2f", monsterHeath );
       String playerHeathString = String.format("%.2f", playerHeath );
        
       PlayerHeathLabel.setText(playerHeathString);
       MonsterHeathLabel.setText(monsterHeathString);
                       }
    }
        if (shop == true)
        {
            if (shopType == 1)
            {
                int lootCode = DiceRoll(6);
                LootTable(lootCode);
                
            }
            if (shopType == 2)
            {
                int healingChance = DiceRoll(10);
                if (healingChance <= 2)
                {
                    playerHeath = intialPlayerHeath/2;
                    mainChat = mainChat + "Yah I got this "+ System.lineSeparator();
                }
                if (healingChance >= 8)
                {
                    playerHeath = playerHeath - 20;
                    mainChat = mainChat + "darn it"+ System.lineSeparator();
                }
                if (healingChance > 2 && healingChance < 8)
                {
                    playerHeath = playerHeath + 50;
                    intialPlayerHeath = intialPlayerHeath + 50;
                    mainChat = mainChat + "Yah 50 heath instead"+ System.lineSeparator();
                }
                RunGame();
            }
            if (shopType == 3)
            {
               CheckPrice(strongSword.getPriceOfItem(), strongSword.getBonusType(),strongSword.getItemStatBonus());
            }
            if (shopType == 4)
            {
                CheckPrice(steelSword.getPriceOfItem(), steelSword.getBonusType(), steelSword.getItemStatBonus());
            }
            if (shopType == 5)
            {
                CheckPrice(steelLegs.getPriceOfItem(), steelLegs.getBonusType(), steelLegs.getItemStatBonus());
            }
            if (shopType == 6)
            {
                CheckPrice(jugernautArmour.getPriceOfItem(), jugernautArmour.getBonusType(), jugernautArmour.getItemStatBonus());
            }
            
        }
    }
    public void RunButtonPushed() throws FileNotFoundException{
    if (shop == false)
    {
    if (monsterLevel != 100)
                        {
                            int randomRun = rand.nextInt(5) + 1;
                            if (randomRun == 1)
                            {
                                monsterHeath = 0;
                                MainChatText.setText("You run away!");
                                CombatChatText.setText("You run away!");

                            }
                            if (randomRun >= 2)
                            {
                                int randomAttack = rand.nextInt(monsterAttack); 
                                if (playerArmour > randomAttack)
                                    randomAttack = 0;
                                if (playerArmour <= randomAttack)
                                    randomAttack = randomAttack - playerArmour;
                                CombatChatText.setText("You recive" + randomAttack + " attack!");
                                playerHeath = playerHeath - randomAttack; 
                            }
                            if (playerHeath <= 0)
                            {
                                Death();
                            }
                            if (monsterHeath <= 0)
                            {
                                RunGame();
                            }
                            
        }
        if (monsterLevel == 100)
        {
            mainChat = mainChat + "You cant run from me"+ System.lineSeparator();
            combatChat = "You cant run away";
            CombatChatText.setText(combatChat);
            MainChatText.setText(mainChat);
        }
        String monsterHeathString = String.format("%.2f", monsterHeath );
            String playerHeathString = String.format("%.2f", playerHeath );
        
            PlayerHeathLabel.setText(playerHeathString);
            MonsterHeathLabel.setText(monsterHeathString);
    }
    if (shop == true)
        {
            if (shopType == 2)
            {
                int healingChance = DiceRoll(10);
                if (healingChance <= 2)
                {
                   playerHeath = playerHeath + 60;
                   intialPlayerHeath = intialPlayerHeath + 60; 
                   mainChat = mainChat + "Even better then 50"+ System.lineSeparator();
                   
                }
                if (healingChance >= 7)
                {
                    playerHeath = playerHeath - 10;
                    mainChat = mainChat + "Opps"+ System.lineSeparator();
                }
                if (healingChance > 2 && healingChance < 8)
                {
                    playerHeath = playerHeath + 50;
                    intialPlayerHeath = intialPlayerHeath + 50;
                    mainChat = mainChat + "Fine 50 heath it is then"+ System.lineSeparator();
                }
                RunGame();
            }
            if (shopType == 3)
            {
               CheckPrice(strongArmour.getPriceOfItem(), strongArmour.getBonusType(),strongArmour.getItemStatBonus());
            }
            if (shopType == 4)
            {
                CheckPrice(steelBroadSword.getPriceOfItem(), steelBroadSword.getBonusType(), steelBroadSword.getItemStatBonus());
            }
            if (shopType == 5)
            {
                CheckPrice(steelBody.getPriceOfItem(), steelBody.getBonusType(), steelBody.getItemStatBonus());
            }
            if (shopType == 6)
            {
                CheckPrice(steelLance.getPriceOfItem(), steelLance.getBonusType(), steelLance.getItemStatBonus());
            }
            
        }
    }
    public void LeaveButtonPushed(){
        if (shop == true)
        {
        RunGame();
        }
        
    }
    
    public int DiceRoll(int rollDice){
       int  randomDice = rand.nextInt(rollDice) + 1;
       return randomDice;
}
    
     private void spawnMonster() {
        int spawnAMonster = DiceRoll(100);
        if (spawnAMonster <= 20)
        {
            monsterAttack = Slime.getMonsterAttack();
            monsterHeath = Slime.getMonsterHeath();
            monsterName = Slime.getMonsterName();
            monsterLevel = Slime.getMonsterLevel();
            NpcImage.setImage(Slime.getMonsterImage());
            mainChat = mainChat + "Random Slime appears"+ System.lineSeparator();
        }
        if (spawnAMonster > 20 && spawnAMonster <= 40)
        {
            monsterAttack = Goblin.getMonsterAttack();
            monsterHeath = Goblin.getMonsterHeath();
            monsterName = Goblin.getMonsterName();
            monsterExp = Goblin.getMonsterExp();
            monsterLevel = Goblin.getMonsterLevel();
            NpcImage.setImage(Goblin.getMonsterImage());
            mainChat = mainChat + "Random Goblin appears"+ System.lineSeparator();
        }
        if (spawnAMonster > 40 && spawnAMonster <= 55)
        {
            monsterAttack = Bandit.getMonsterAttack();
            monsterHeath = Bandit.getMonsterHeath();
            monsterName = Bandit.getMonsterName();
            monsterExp = Bandit.getMonsterExp();
            monsterLevel = Bandit.getMonsterLevel();
            NpcImage.setImage(Bandit.getMonsterImage());
            mainChat = mainChat + "Random Bandit appears"+ System.lineSeparator();
        }
        if (spawnAMonster > 55 && spawnAMonster <= 70)
        {
            monsterAttack = Dwarf.getMonsterAttack();
            monsterHeath = Dwarf.getMonsterHeath();
            monsterName = Dwarf.getMonsterName();
            monsterExp = Dwarf.getMonsterExp();
            monsterLevel = Dwarf.getMonsterLevel();
            NpcImage.setImage(Dwarf.getMonsterImage());
            mainChat = mainChat + "Random Dwarf appears"+ System.lineSeparator();
        }
        if (spawnAMonster > 70 && spawnAMonster <= 85)
        {
            monsterAttack = Zombie.getMonsterAttack();
            monsterHeath = Zombie.getMonsterHeath();
            monsterName = Zombie.getMonsterName();
            monsterExp = Zombie.getMonsterExp();
            monsterLevel = Zombie.getMonsterLevel();
            NpcImage.setImage(Zombie.getMonsterImage());
            mainChat = mainChat + "Random Zombie appears"+ System.lineSeparator();
        }
        if (spawnAMonster > 85 && spawnAMonster <= 95)
        {
            monsterAttack = Knight.getMonsterAttack();
            monsterHeath = Knight.getMonsterHeath();
            monsterName = Knight.getMonsterName();
            monsterExp = Knight.getMonsterExp();
            monsterLevel = Knight.getMonsterLevel();
            NpcImage.setImage(Knight.getMonsterImage());
            mainChat = mainChat + "Random Knight appears"+ System.lineSeparator();
        }
        if (spawnAMonster > 95 && spawnAMonster <= 100)
        {
            monsterAttack = Demon.getMonsterAttack();
            monsterHeath = Demon.getMonsterHeath();
            monsterName = Demon.getMonsterName();
            monsterExp = Demon.getMonsterExp();
            monsterLevel = Demon.getMonsterLevel();
            NpcImage.setImage(Demon.getMonsterImage());
            mainChat = mainChat + "Random Demon appears"+ System.lineSeparator();
            
        }
       monsterAttack = monsterAttack*floorLevel;
       monsterHeath = monsterHeath*floorLevel;
       String monsterHeathString = String.format("%.2f", monsterHeath );
       String monsterAttackString = String.format("%d", monsterAttack );
        
       MonsterAttackLabel.setText(monsterAttackString);
       MonsterHeathLabel.setText(monsterHeathString);
       MonsterNameLabel.setText(monsterName);
       
        
    }
     private void LootTable(int monsterCode)
     {
         int lootPicker = DiceRoll(100);
         if(monsterCode == 1)
         {
             if(lootPicker <= 25)
             {
                 playerHeath = playerHeath + HeathPot.getLootBonus();
                 intialPlayerHeath = intialPlayerHeath + HeathPot.getLootBonus();
                 mainChat = mainChat + "You have recived a heath pot!"+ System.lineSeparator();
                 mainChat = mainChat + "player heath bonous is:" + HeathPot.getLootBonus() + System.lineSeparator();
             }
             if (lootPicker >= 26 && lootPicker <= 50)
             {
                 playerHeath = playerHeath + HeathPotFive.getLootBonus();
                 intialPlayerHeath = intialPlayerHeath + HeathPotFive.getLootBonus();
                 mainChat = mainChat + "You have recived a jelly sword!"+ System.lineSeparator();
                 mainChat = mainChat + "player heath bonous is:" + HeathPotFive.getLootBonus() + System.lineSeparator();
             }
             if (lootPicker >= 51 && lootPicker <= 75)
             {
                 playerArmour = playerArmour + BasicArmour.getLootBonus();
                 mainChat = mainChat + "You have recived basic armour!"+ System.lineSeparator();
                 mainChat = mainChat + "player armour bonous is:" + BasicArmour.getLootBonus() + System.lineSeparator();
             }
             if (lootPicker >= 76)
             {
                 System.out.println("20 coins");
                 playerCoins = playerCoins + TwentyCoins.getLootBonus();
                 mainChat = mainChat + "You have recived 20 coins!"+ System.lineSeparator();
                 mainChat = mainChat + "player coin bonous is:" + TwentyCoins.getLootBonus() + System.lineSeparator();
                
             }
         }
         if (monsterCode == 2)
           {
            if (lootPicker >= 0 && lootPicker <= 40)
            {
                 playerHeath = playerHeath + HeathPot.getLootBonus();
                 intialPlayerHeath = intialPlayerHeath + HeathPot.getLootBonus();
                 mainChat = mainChat + "You have recived a heath pot!"+ System.lineSeparator();
                 mainChat = mainChat + "player heath bonous is:" + HeathPot.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 41 && lootPicker <= 50)
            {
                playerAttack = playerAttack + Dagger.getLootBonus();
                mainChat = mainChat + "You have recived a bandit sword!"+ System.lineSeparator();
                mainChat = mainChat + "player attack bonous is:" + Dagger.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 51 && lootPicker <= 60)
            {
                playerArmour = playerArmour + Boots.getLootBonus();
                mainChat = mainChat + "You have recived boots!"+ System.lineSeparator();
                mainChat = mainChat + "player armour bonous is:" + Boots.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 61)
            {
                
                playerCoins = playerCoins + FortyCoins.getLootBonus();
                mainChat = mainChat + "You have recived 50 coins!"+ System.lineSeparator();
                mainChat = mainChat + "player coin bonous is:" + FiftyCoins.getLootBonus() + System.lineSeparator();
            }
           }
         if (monsterCode == 3)
           {
            if (lootPicker >= 0 && lootPicker <= 25)
            {
                
                playerHeath = playerHeath + HeathPot.getLootBonus();
                intialPlayerHeath = intialPlayerHeath + HeathPot.getLootBonus();
                mainChat = mainChat + "You have recived a heath pot!"+ System.lineSeparator();
                 mainChat = mainChat + "player heath bonous is:" + HeathPot.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 26 && lootPicker <= 50)
            {
                
                playerAttack = playerAttack + Spear.getLootBonus();
                mainChat = mainChat + "You have recived a Goblin Spear!"+ System.lineSeparator();
                 mainChat = mainChat + "player attack bonous is:" + Spear.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 51 && lootPicker <= 75)
            {
                mainChat = mainChat + "Recieved Nothing!"+ System.lineSeparator();
                 
                
            }
            if (lootPicker >= 76)
            {
 
                playerCoins = playerCoins + FiveCoins.getLootBonus();
                mainChat = mainChat + "You have recived 5 coins!"+ System.lineSeparator();
                mainChat = mainChat + "player coin bonous is:" + FiveCoins.getLootBonus() + System.lineSeparator();
            }
           }
           if (monsterCode == 4)
           {
            if (lootPicker >= 0 && lootPicker <= 35)
            {
   
                playerHeath = playerHeath + HeathPotThree.getLootBonus();
                intialPlayerHeath = intialPlayerHeath + HeathPotThree.getLootBonus();
                mainChat = mainChat + "You have recived 3 heath pots!"+ System.lineSeparator();
                mainChat = mainChat + "player heath bonous is:" + HeathPotThree.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 36 && lootPicker <= 56)
            {
           
                playerArmour = playerArmour + HeavyShirt.getLootBonus();
                mainChat = mainChat + "You have recived a Heavy tshirt!"+ System.lineSeparator();
                mainChat = mainChat + "player armour bonous is:" + HeavyShirt.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 57 && lootPicker <= 60)
            {
          
                playerAttack = playerAttack + LeftArm.getLootBonus();
                mainChat = mainChat + "You have recived a left arm!"+ System.lineSeparator();
                mainChat = mainChat + "player attack bonous is:" + LeftArm.getLootBonus() + System.lineSeparator();
            }
            if  (lootPicker >= 61)
            {
        
                playerCoins = playerCoins + FortyCoins.getLootBonus();
                mainChat = mainChat + "You have recived 40 coins!"+ System.lineSeparator();
                mainChat = mainChat + "player coin bonous is:" + FortyCoins.getLootBonus() + System.lineSeparator();
            }
           }
          if (monsterCode == 5)
          {
            if (lootPicker >= 0 && lootPicker <= 10)
            {
          
                playerArmour = playerArmour + KnightHelmet.getLootBonus();
                mainChat = mainChat + "You have recived a Knights Helmet!"+ System.lineSeparator();
                mainChat = mainChat + "player armour bonous is:" + KnightHelmet.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 11 && lootPicker <= 20)
            {
                
                playerAttack = playerAttack + KnightSword.getLootBonus();
                mainChat = mainChat + "You have recived a Knights Sword!"+ System.lineSeparator();
                mainChat = mainChat + "player attack bonous is:" + KnightSword.getLootBonus() + System.lineSeparator();
                
            }
            if (lootPicker >= 21 && lootPicker <= 25)
            {
                
                playerArmour = playerArmour + KnightChestPlate.getLootBonus();
                mainChat = mainChat + "You have recived a Knights Chestplate!"+ System.lineSeparator();
                mainChat = mainChat + "player armour bonous is:" + KnightChestPlate.getLootBonus() + System.lineSeparator();
                
            }
            if (lootPicker >= 26)
            {
                
                playerCoins = playerCoins + FiftyCoins.getLootBonus();
                mainChat = mainChat + "You have recived 50 coins!"+ System.lineSeparator();
                mainChat = mainChat + "player coin bonous is:" + FortyCoins.getLootBonus() + System.lineSeparator();
            }
          }
            if (monsterCode == 6)
          {
            if (lootPicker >= 0 && lootPicker <= 40)
            {
                
                playerHeath = playerHeath + HeathPot.getLootBonus();
                intialPlayerHeath = intialPlayerHeath + HeathPot.getLootBonus();
                mainChat = mainChat + "You have recived a heath pot!"+ System.lineSeparator();
                mainChat = mainChat + "player heath bonous is:" + HeathPot.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 41 && lootPicker <= 80)
            {
                System.out.println("You have recived a lava bucket!");
                System.out.println("Sadly you cant use that!");
                mainChat = mainChat + "You have recived a lava bucket... that doesnt do anything!"+ System.lineSeparator();
                
                
            }
            if (lootPicker >= 81 && lootPicker <= 95)
            {
                
                playerAttack = playerAttack + Hammer.getLootBonus();
                mainChat = mainChat + "You have recived a hammer!"+ System.lineSeparator();
                mainChat = mainChat + "player attack bonous is:" + Hammer.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 96)
            {
                
                playerCoins = playerCoins + SeventyFiveCoins.getLootBonus();
                mainChat = mainChat + "You have recived a 75 coins!"+ System.lineSeparator();
                mainChat = mainChat + "player coin bonous is:" + SeventyFiveCoins.getLootBonus() + System.lineSeparator();
            }
          }
          if (monsterCode == 100)
          {
            if (lootPicker >= 0 && lootPicker <= 2)
            {
                
                playerAttack = playerAttack + DemonBlade.getLootBonus();
                mainChat = mainChat + "You have recived a Demon Blade!"+ System.lineSeparator();
                mainChat = mainChat + "player attack bonous is:" + DemonBlade.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 3 && lootPicker <= 4)
            {
        
                playerArmour = playerArmour + ThornArmour.getLootBonus();
                mainChat = mainChat + "You have recived Thorn Armour!"+ System.lineSeparator();
                mainChat = mainChat + "player armour bonous is:" + ThornArmour.getLootBonus() + System.lineSeparator();
            }
            if (lootPicker >= 44)
            {
               
                mainChat = mainChat + "You have recived nothing!"+ System.lineSeparator();
                
                
            }
            if (lootPicker >= 29 && lootPicker <= 44)
            {
              
                playerCoins = playerCoins + HundredFiveCoins.getLootBonus();
                mainChat = mainChat + "You have recived 100 coins!"+ System.lineSeparator();
                mainChat = mainChat + "player coin bonous is:" + HundredFiveCoins.getLootBonus() + System.lineSeparator();
            }
          }
          RunGame();
         
     }
     private void BlackMarket() {
        shopType = 6;
        ShopButtonOneLabel.setText(superPots.getItemName());
        ShopButtonTwoLabel.setText(jugernautArmour.getItemName());
        ShopButtonThreeLabel.setText(steelLance.getItemName());
        MonsterNameLabel.setText("Black Market");
        combatChat = "Price of superPot:" + superPots.getPriceOfItem() 
                + System.lineSeparator() 
                + "Price of Juggernaut Armour:" + jugernautArmour.getPriceOfItem()
                + System.lineSeparator() +
                "Price of Steel Lance:" + steelLance.getPriceOfItem()
                + System.lineSeparator();
        CombatChatText.setText(combatChat);
        mainChat = mainChat + "Hello Im Mary, take a look at my wares" + System.lineSeparator();
             MainChatText.setText(mainChat);
        NpcImage.setImage(shopImage);
        
        
    }
     private void AmourSmith() {
        shopType = 5;
        ShopButtonOneLabel.setText(basicHelmet.getItemName());
        ShopButtonTwoLabel.setText(steelLegs.getItemName());
        ShopButtonThreeLabel.setText(steelBody.getItemName());
        MonsterNameLabel.setText("Armour Smith");
        combatChat = "Price of basic helmet:" + basicHelmet.getPriceOfItem() 
                + System.lineSeparator() 
                + "Price of steel legs:" + steelLegs.getPriceOfItem()
                + System.lineSeparator() +
                "Price of steel body" + steelBody.getPriceOfItem()
                + System.lineSeparator();
        CombatChatText.setText(combatChat);
        mainChat = mainChat + "Hello Im Laura the armour smith, best gear here" + System.lineSeparator();
             MainChatText.setText(mainChat);
        NpcImage.setImage(shopImage);
    }
     private void WeaponSmith() {
        shopType = 4;
        ShopButtonOneLabel.setText(kitchenKnife.getItemName());
        ShopButtonTwoLabel.setText(steelSword.getItemName());
        ShopButtonThreeLabel.setText(steelBroadSword.getItemName());
        MonsterNameLabel.setText("Weapon Smith");
        combatChat = "Price of kitchen knife:" + kitchenKnife.getPriceOfItem() 
                + System.lineSeparator() 
                + "Price of steel sword" + steelSword.getPriceOfItem()
                + System.lineSeparator() +
                "Price of steel broadsword" + steelBroadSword.getPriceOfItem()
                + System.lineSeparator();
        CombatChatText.setText(combatChat);
        mainChat = mainChat + "Hello Im Ash the weaponSmith, only have the best" + System.lineSeparator();
             MainChatText.setText(mainChat);
        NpcImage.setImage(shopImage);
    }
     private void GeneralStore() {
        shopType = 3;
        ShopButtonOneLabel.setText(heathPots.getItemName());
        ShopButtonTwoLabel.setText(strongSword.getItemName());
        ShopButtonThreeLabel.setText(strongArmour.getItemName());
        MonsterNameLabel.setText("General Store");
        combatChat = "Price of heathPots:" + heathPots.getPriceOfItem() 
                + System.lineSeparator() 
                + "Price of strong sword" + strongSword.getPriceOfItem()
                + System.lineSeparator() +
                "Price of strong armour" + strongArmour.getPriceOfItem()
                + System.lineSeparator();
        CombatChatText.setText(combatChat); 
        mainChat = mainChat + "Hello Im Boby the general store keep, how may I help you" + System.lineSeparator();
             MainChatText.setText(mainChat);
        NpcImage.setImage(shopImage);
    }
     private void FairyShop() {
        shopType = 2;
        ShopButtonOneLabel.setText("Full Heath");
        ShopButtonTwoLabel.setText("50% Heath ");
        ShopButtonThreeLabel.setText("Add 50 more heath");
        MonsterNameLabel.setText("Fairy");
        mainChat = mainChat + "Hello Im emilie the fairy tell me what you need" + System.lineSeparator();
             MainChatText.setText(mainChat);
        NpcImage.setImage(fairyImage);
    }
     private void ChestShop() {
        shopType = 1;
        ShopButtonOneLabel.setVisible(false);
        ShopButtonTwoLabel.setVisible(false);
        ShopButtonThreeLabel.setVisible(false);
        AttackButton.setVisible(false);
        DefendButton.setText("Open");
        RunButton.setVisible(false);
        MonsterNameLabel.setText("Chester");
        mainChat = mainChat + "Hello Im chester open me" + System.lineSeparator();
             MainChatText.setText(mainChat);
        NpcImage.setImage(chestImage);
     }
     
     private void CheckPrice(int priceOfItem, int itemType, int itemBonus){
         if (priceOfItem <= playerCoins)
         {
             mainChat = mainChat + "Sold" + System.lineSeparator();
             playerCoins = playerCoins - priceOfItem;
             //1 attack 2 armour 3 heath 
             if (itemType == 1)
             {
                 playerAttack = playerAttack + itemBonus;
             }
             if (itemType == 2)
             {
                 playerArmour = playerArmour + itemBonus; 
             }
             if (itemType == 3)
             {
                 playerHeath = playerHeath + itemBonus;
                 intialPlayerHeath = intialPlayerHeath + itemBonus;
             }
        String playerAttackString = String.format("%d", playerAttack );
        String playerCoinsString = String.format("%d", playerCoins );
        String playerArmourString = String.format("%d", playerArmour );
        String playerHeathString = String.format("%.2f", playerHeath ); 
        
        PlayerHeathLabel.setText(playerHeathString);
        PlayerAttackLabel.setText(playerAttackString);
        PlayerCoinsLabel.setText(playerCoinsString);
        PlayerAmourLabel.setText(playerArmourString);
        MainChatText.setText(mainChat);
             
                 
         }
         else 
         {
             mainChat = mainChat + "You dont have the right amount" + System.lineSeparator();
             MainChatText.setText(mainChat);
         }
         
     }
     private void Death() throws FileNotFoundException{
        CombatChatText.setVisible(false);
        MainChatText.setVisible(false);
        
        PlayerHeathMainLabel.setVisible(false);
        PlayerAttackMainLabel.setVisible(false);
        PlayerAmourMainLabel.setVisible(false);
        PlayerCoinsMainLabel.setVisible(false);
        PlayerLevelMainLabel.setVisible(false);
        
        PlayerHeathLabel.setVisible(false);
        PlayerAttackLabel.setVisible(false);
        PlayerCoinsLabel.setVisible(false);
        PlayerLevelLabel.setVisible(false);
        PlayerAmourLabel.setVisible(false);
        
         AttackButton.setVisible(false);
         DefendButton.setVisible(false);
         RunButton.setVisible(false);
         LeaveButton.setVisible(false);
         
         FloorMainLabel.setVisible(false);
         FloorLabel.setVisible(false);
         
         ShopButtonOneLabel.setVisible(false);
         ShopButtonTwoLabel.setVisible(false);
         ShopButtonThreeLabel.setVisible(false);
         
         MonsterHeathLabel.setVisible(false);
         MonsterAttackLabel.setVisible(false);
         MonsterNameLabel.setVisible(false);
         MonsterAttackMainLabel.setVisible(false);
         MonsterHeathMainLabel.setVisible(false);
         scoreBoard();
     }
     private void LevelUp(int Exp){
         LevelUp = LevelUp + Exp;
         System.out.print("Your Total Exp is " + LevelUp);
         if (LevelUp >= LevelUpMax)
         {
             LevelUp = 0;
             LevelUpMax =+ 1000;
             int LevelUpAttack = DiceRoll(10);
             int LevelUpHeath = DiceRoll(50);
             playerLevel++;
             playerAttack = playerAttack + LevelUpAttack;
             playerHeath = playerHeath + LevelUpHeath;
             intialPlayerHeath = intialPlayerHeath + LevelUpHeath;
         }
         LootTable(monsterLevel);
                 
         }
         public void scoreBoard() throws FileNotFoundException {

            Formatter score = new Formatter("ScoreBoard.docx");
            score.format("Floor:" + floorLevel + System.lineSeparator() + 
                    "Attack:" + playerAttack + System.lineSeparator() +
                    "Armour:" + playerArmour + System.lineSeparator() + 
                    "Level:" + playerLevel);
            score.close();

}
 

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        CombatChatText.setEditable(false);
        MainChatText.setEditable(false);
        StoryChatText.setEditable(false);
        
        CombatChatText.setVisible(false);
        MainChatText.setVisible(false);
        
        PlayerHeathMainLabel.setVisible(false);
        PlayerAttackMainLabel.setVisible(false);
        PlayerAmourMainLabel.setVisible(false);
        PlayerCoinsMainLabel.setVisible(false);
        PlayerLevelMainLabel.setVisible(false);
        
        PlayerHeathLabel.setVisible(false);
        PlayerAttackLabel.setVisible(false);
        PlayerCoinsLabel.setVisible(false);
        PlayerLevelLabel.setVisible(false);
        PlayerAmourLabel.setVisible(false);
        
         AttackButton.setVisible(false);
         DefendButton.setVisible(false);
         RunButton.setVisible(false);
         LeaveButton.setVisible(false);
         
         FloorMainLabel.setVisible(false);
         FloorLabel.setVisible(false);
         
         ShopButtonOneLabel.setVisible(false);
         ShopButtonTwoLabel.setVisible(true);
         ShopButtonThreeLabel.setVisible(false);
         ShopButtonTwoLabel.setText("You will never leave haha");
         NpcImage.setVisible(false);
         MonsterHeathLabel.setVisible(false);
         MonsterAttackLabel.setVisible(false);
         MonsterNameLabel.setVisible(false);
         MonsterAttackMainLabel.setVisible(false);
         MonsterHeathMainLabel.setVisible(false);
         
        classButtonToggle = new ToggleGroup();
        BerskerRadioButton.setToggleGroup(classButtonToggle);
        AssassinRadioButton.setToggleGroup(classButtonToggle);
        KnightRadioButton.setToggleGroup(classButtonToggle);
        SquireRadioButton.setToggleGroup(classButtonToggle);
        MerchantRadioButton.setToggleGroup(classButtonToggle);
  
        
        
        String monsterHeathString = String.format("%.2f", monsterHeath );
        String monsterAttackString = String.format("%d", monsterAttack );
        
        String playerHeathString = String.format("%.2f", playerHeath );
        String playerAttackString = String.format("%d", playerAttack );
        String playerCoinsString = String.format("%d", playerCoins );
        String playerArmourString = String.format("%d", playerArmour );
        String playerLevelString = String.format("%d", playerLevel );
        
        String floorLevelString = String.format("%d", floorLevel);
        
        PlayerHeathLabel.setText(playerHeathString);
        PlayerAttackLabel.setText(playerAttackString);
        PlayerCoinsLabel.setText(playerCoinsString);
        PlayerLevelLabel.setText(playerLevelString);
        PlayerAmourLabel.setText(playerArmourString);
        

        
        FloorLabel.setText(floorLevelString);
        
        
    }

    
  
    
}
