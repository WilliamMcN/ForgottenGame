/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgottengame;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author williammc
 */
public class ForgottenMazeLayoutControllerTest {
    
    public ForgottenMazeLayoutControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of radioButtonChanged method, of class ForgottenMazeLayoutController.
     */
    @Test
    public void testRadioButtonChanged() {
        System.out.println("radioButtonChanged");
        ForgottenMazeLayoutController instance = new ForgottenMazeLayoutController();
        instance.radioButtonChanged();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of StartButtonPushed method, of class ForgottenMazeLayoutController.
     */
    @Test
    public void testStartButtonPushed() {
        System.out.println("StartButtonPushed");
        ForgottenMazeLayoutController instance = new ForgottenMazeLayoutController();
        instance.StartButtonPushed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RunGame method, of class ForgottenMazeLayoutController.
     */
    @Test
    public void testRunGame() {
        System.out.println("RunGame");
        ForgottenMazeLayoutController instance = new ForgottenMazeLayoutController();
        instance.RunGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AttackButtonPushed method, of class ForgottenMazeLayoutController.
     */
    @Test
    public void testAttackButtonPushed() {
        System.out.println("AttackButtonPushed");
        ForgottenMazeLayoutController instance = new ForgottenMazeLayoutController();
        instance.AttackButtonPushed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DefendButtonPushed method, of class ForgottenMazeLayoutController.
     */
    @Test
    public void testDefendButtonPushed() {
        System.out.println("DefendButtonPushed");
        ForgottenMazeLayoutController instance = new ForgottenMazeLayoutController();
        instance.DefendButtonPushed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RunButtonPushed method, of class ForgottenMazeLayoutController.
     */
    @Test
    public void testRunButtonPushed() {
        System.out.println("RunButtonPushed");
        ForgottenMazeLayoutController instance = new ForgottenMazeLayoutController();
        instance.RunButtonPushed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LeaveButtonPushed method, of class ForgottenMazeLayoutController.
     */
    @Test
    public void testLeaveButtonPushed() {
        System.out.println("LeaveButtonPushed");
        ForgottenMazeLayoutController instance = new ForgottenMazeLayoutController();
        instance.LeaveButtonPushed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DiceRoll method, of class ForgottenMazeLayoutController.
     */
    @Test
    public void testDiceRoll() {
        System.out.println("DiceRoll");
        int rollDice = 0;
        ForgottenMazeLayoutController instance = new ForgottenMazeLayoutController();
        int expResult = 0;
        int result = instance.DiceRoll(rollDice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class ForgottenMazeLayoutController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        ForgottenMazeLayoutController instance = new ForgottenMazeLayoutController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
