
package forgottengame;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LauchForgottenMazeView extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ForgottenMazelayout.fxml"));
        
        AnchorPane anchorPane = loader.load();
       
        Scene scene = new Scene(anchorPane);
        
        primaryStage.setTitle("Forgotten Maze");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          launch(args);
    }
    
}