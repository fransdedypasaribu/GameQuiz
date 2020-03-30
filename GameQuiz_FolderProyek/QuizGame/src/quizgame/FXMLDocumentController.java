/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Still D.R.E
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public TextField userName;
    
    public static String usrName;
   
    @FXML
    public Button closeButton, playButton, cancelPlayButton, playNowButton;
 
    public Parent root;
    public Stage stage;
    public Scene scene;

    @FXML
    private void moveCredit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Credits.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Quiz Game");
        stage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Quiz Game");
        stage.show();
    }

    @FXML
    private void quit(ActionEvent event) throws IOException {
       int exit = JOptionPane.showConfirmDialog(null, "Are you sure to quit this game?", "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            scene = new Scene(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Quiz Game");
            stage.show();
        }
    }

    @FXML
    private void play(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Username.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Quiz Game");
        stage.show();
    }

    @FXML
    private void cancelPlay(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Quiz Game");
        stage.show();
    }

    @FXML
    private void playNow(ActionEvent event) throws IOException {
        try {
            Class.forName("org.h2.Driver");
            try {
                Connection connection = DriverManager.getConnection("jdbc:h2:E:/FD/IT DEL/KULIAH/16/SEMESTER 4/PBO/Proyek/GameQuiz_FolderProyek/QuizGame", "frans", "dedy");
                Statement stmt = connection.createStatement();
                usrName = userName.getText();
                String query = "INSERT INTO SCORE VALUES ('%s', 0)";
                query = String.format(query, usrName);
                stmt.execute(query);
                connection.close();
                root = FXMLLoader.load(getClass().getResource("Play.fxml"));
                scene = new Scene(root );
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Quiz Game");
                stage.show();
            } catch (SQLException ex) {
                System.out.println("SQLExeption: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        } catch (ClassNotFoundException | NumberFormatException ex) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
