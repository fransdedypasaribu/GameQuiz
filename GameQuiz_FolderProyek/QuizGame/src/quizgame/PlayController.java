/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Still D.R.E
 */
public class PlayController implements Initializable {

    @FXML
    private AnchorPane playPane;

    @FXML
    private ToggleGroup tgGroup;

    @FXML
    private Label questions;

    @FXML
    private RadioButton btnA;

    @FXML
    private RadioButton btnB;

    @FXML
    private RadioButton btnC;

    @FXML
    private RadioButton btnD;

    
    private int score;

    @FXML
    private Button saveBtn;

    @FXML
    private Button finishBtn;

    @FXML
    private Label questionNum;

    private int questNum = 0;

    public void btnHandler() {
        tgGroup = new ToggleGroup();
        this.btnA.setToggleGroup(tgGroup);
        this.btnB.setToggleGroup(tgGroup);
        this.btnC.setToggleGroup(tgGroup);
        this.btnD.setToggleGroup(tgGroup);
    }

    public void questionSet() {
        btnHandler();
        switch (questNum) {
            case 0:
                questions.setText("What kind of variables a class can consist of?");
                btnA.setText("A) class variables, instance variables");
                btnB.setText("B) class variables, local variables, instance variables"); //true
                btnC.setText("C) class variables");
                btnD.setText("D) class variables, local variables");
                questionNum.setText("1");
                questNum++;
                btnHandler();
                setBtnFalse();
                break;
            case 1:
                questions.setText("Which of the following is true about public access modifier?");
                btnA.setText("A) Variables, methods and constructors which are declared public can be accessed by any class."); //true
                btnB.setText("B) Variables, methods and constructors which are declared public can be accessed by any class lying in same package.");
                btnC.setText("C) Variables, methods and constructors which are declared public in the superclass can be accessed only by its child class.");
                btnD.setText("D) None of the above.");
                questionNum.setText("2");
                questNum++;
                btnHandler();
                setBtnFalse();
                break;
            case 2:
                questions.setText("Which operator is considered to be with highest precedence?");
                btnA.setText("A) (), []"); //true
                btnB.setText("B) =");
                btnC.setText("C) ?:");
                btnD.setText("D) %");
                questionNum.setText("3");
                questNum++;
                btnHandler();
                setBtnFalse();
                break;
            case 3:
                questions.setText("What of the following is the default value of an instance variable?");
                btnA.setText("A) null");
                btnB.setText("B) 0");
                btnC.setText("C) Depends upon the type of variable"); //true
                btnD.setText("D) Not assigned");
                questionNum.setText("4");
                questNum++;
                btnHandler();
                setBtnFalse();
                break;
            case 4:
                questions.setText("What term is used for hiding the details of an object from the other parts of a program?");
                btnA.setText("A) Data Mining");
                btnB.setText("B) Encapsulation"); //true
                btnC.setText("C) Inheritance");
                btnD.setText("D) Polymorphism");
                questionNum.setText("5");
                questNum++;
                btnHandler();
                setBtnFalse();
                break;
            case 5:
                questions.setText("Enums are used to declare variables that represent...");
                btnA.setText("A) members of a fixed set"); //true
                btnB.setText("B) interfaces");
                btnC.setText("C) integers");
                btnD.setText("D) classes");
                questionNum.setText("6");
                questNum++;
                btnHandler();
                setBtnFalse();
                break;
            case 6:
                questions.setText("What would the name of the setter method for the class variable named 'age' be?");
                btnA.setText("A) initAge");
                btnB.setText("B) getAge");
                btnC.setText("C) setAge"); //true
                btnD.setText("D) Age");
                questionNum.setText("7");
                questNum++;
                btnHandler();
                setBtnFalse();
                break;
            case 7:
                questions.setText("How many packages can be contained in a Java program?");
                btnA.setText("A) none");
                btnB.setText("B) as many as you need"); //true
                btnC.setText("C) one");
                btnD.setText("D) two");
                questionNum.setText("8");
                questNum++;
                btnHandler();
                setBtnFalse();
                break;
            case 8:
                questions.setText("How many times can you call a method?");
                btnA.setText("A) one");
                btnB.setText("B) two");
                btnC.setText("C) as many as you want"); //true
                btnD.setText("D) five");
                questionNum.setText("9");
                questNum++;
                btnHandler();
                setBtnFalse();
                break;
            case 9:
                questions.setText("How is a do while loop different from a while loop?");
                btnA.setText("A) A do while loop runs your code at least one time."); //true
                btnB.setText("B) A while loop runs the code before testing the condition.");
                btnC.setText("C) A do while loop tests the condition before running the code.");
                btnD.setText("D) A while loops runs your code at least one time.");
                questionNum.setText("10");
                questNum++;
                btnHandler();
                setBtnFalse();
                break;
            default:
                break;
        }
    }

    private void setBtnFalse() {
        btnA.setSelected(false);
        btnB.setSelected(false);
        btnC.setSelected(false);
        btnD.setSelected(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        questionSet();

        saveBtn.setOnAction(e -> {

            if ("1".equals(questionNum.getText())) {
                if (btnB.isSelected()) {
                    score += 10;
                } else {
                    score -= 5;
                }
            } else if ("2".equals(questionNum.getText())) {
                if (btnA.isSelected()) {
                    score += 10;
                } else {
                    score -= 5;
                }
            } else if ("3".equals(questionNum.getText())) {
                if (btnA.isSelected()) {
                    score += 10;
                } else {
                    score -= 5;
                }
            } else if ("4".equals(questionNum.getText())) {
                if (btnC.isSelected()) {
                    score += 10;
                } else {
                    score -= 5;
                }
            } else if ("5".equals(questionNum.getText())) {
                if (btnB.isSelected()) {
                    score += 10;
                } else {
                    score -= 5;
                }
            } else if ("6".equals(questionNum.getText())) {
                if (btnA.isSelected()) {
                    score += 10;
                } else {
                    score -= 5;
                }
            } else if ("7".equals(questionNum.getText())) {
                if (btnC.isSelected()) {
                    score += 10;
                } else {
                    score -= 5;
                }
            } else if ("8".equals(questionNum.getText())) {
                if (btnB.isSelected()) {
                    score += 10;
                } else {
                    score -= 5;
                }
            } else if ("9".equals(questionNum.getText())) {
                if (btnC.isSelected()) {
                    score += 10;
                } else {
                    score -= 5;
                }
            } else if ("10".equals(questionNum.getText())) {
                if (btnA.isSelected()) {
                    score += 10;
                } else {
                    score -= 5;
                }
                FXMLLoader root;
                try {
                    ScoreController sc = new ScoreController(score);

                    root = new FXMLLoader(getClass().getResource("Score.fxml"));
                    root.setController(sc);
                    Scene scene = new Scene(root.load());
                    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Quiz Game");
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(PlayController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            questionSet();
        });

        finishBtn.setOnAction(e -> {
            FXMLLoader root;
            try {
                Class.forName("org.h2.Driver");
                try {
                    ScoreController sc = new ScoreController(score);
                    Connection connection = DriverManager.getConnection("jdbc:h2:E:/FD/IT DEL/KULIAH/16/SEMESTER 4/PBO/Proyek/GameQuiz_FolderProyek/QuizGame", "frans", "dedy");
                    Statement stmt = connection.createStatement();
                    String query = "UPDATE SCORE SET SCORES = " + score + " WHERE NAME = '" + FXMLDocumentController.usrName + "'";
                    query = String.format(query, score);
                    stmt.execute(query);
                    connection.close();
                    
                    root = new FXMLLoader(getClass().getResource("Score.fxml"));
                    root.setController(sc);
                    Scene scene = new Scene(root.load());
                    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Quiz Game");
                    stage.show();
                } catch (SQLException ex) {
                    System.out.println("SQLExeption: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                } catch (IOException ex) {
                    Logger.getLogger(PlayController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException | NumberFormatException ex) {

            }

        });

    }
}
