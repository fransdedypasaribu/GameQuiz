/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.YELLOW;
import javafx.stage.Stage;

/**
 *
 * @author Still D.R.E
 */
public class ScoreController implements Initializable {

    @FXML
    private Button playAgn, quitGm;

    @FXML
    private Label yourScore;

    private int score;

    public ScoreController() {

    }

    public ScoreController(int score) {
        this.score = score;
    }
    
    @FXML
    private void playAgn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Quiz Game");
        stage.show();
    }
    
    @FXML
    private void quitGm(ActionEvent event) throws IOException {
            System.exit(0);
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (score < 0) {
            yourScore.setText("0");
            yourScore.setTextFill(RED);
        } else if (score <= 50) {
            yourScore.setText(Integer.toString(score));
            yourScore.setTextFill(RED);
        } else if (score < 70) {
            yourScore.setText(Integer.toString(score));
            yourScore.setTextFill(YELLOW);
        } else {
            yourScore.setText(Integer.toString(score));
            yourScore.setTextFill(GREEN);
        }

    }
}
