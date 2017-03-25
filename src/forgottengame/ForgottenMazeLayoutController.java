/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgottengame;

import java.awt.Button;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import java.util.Scanner;

/**
 * FXML Controller class
 *
 * @author williammc
 */
public class ForgottenMazeLayoutController implements Initializable {
    
    @FXML private Label FloorMainLabel;
    @FXML private Label FloorLabel;
    
    @FXML private Label MonsterHeathMainLabel;
    @FXML private Label MonsterLevelMainLabel;
    
    @FXML private Label MonsterHeathLabel;
    @FXML private Label MonsterLevelLabel;
    
    @FXML private Label PlayerHeathMainLabel; 
    @FXML private Label PlayerAttackMainLabel;
    @FXML private Label PlayerAmourMainLabel;
    @FXML private Label PlayerCoinsMainLabel;
    @FXML private Label PlayerLevelMainLabel;
    
    @FXML private Label PlayerHeathLabel; 
    @FXML private Label PlayerAttackLabel;
    @FXML private Label PlayerAmourLabel;
    @FXML private Label PlayerCoinsLabel;
    @FXML private Label PlayerLevelLabel;
    
    @FXML private Button AttackButton;
    @FXML private Button DefendButton;
    @FXML private Button RunButton;
    @FXML private Button LeaveButton;
    
    @FXML private TextField MainChatText; 
    @FXML private TextField CombatChatText;
    
    //@FXML private Image NPCImage;
    
    
    public void AttackButtonPushed(){
        
        int monsterHeath = 100;
        Random rand= new Random();
        int armour = 0;
        int AttackOutput = 10;
        int playerAttack = 10;
        int playerHeath = 100;
        int randomAttack = rand.nextInt(playerAttack); 
        monsterHeath = monsterHeath - randomAttack;
        int randomMobAttack = rand.nextInt(AttackOutput);
        if (armour > randomMobAttack)
            randomMobAttack = 0;
        if (armour <= randomMobAttack)
        {
            randomMobAttack = randomMobAttack - armour;
            playerHeath = playerHeath - randomMobAttack;
        }
        String monsterHeathString = String.format("%f", monsterHeath );
        String playerHeathString = String.format("%f", playerHeath );
        
       PlayerHeathLabel.setText(playerHeathString);
       MonsterHeathLabel.setText(monsterHeathString);
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
