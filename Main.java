package org.ict;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main extends JFrame {
    private JButton rollButton;
    private JTextArea gameInfo;
    private JPanel gameBoard;
    private long playerPosition;

    ///////////////start of parser//////////////////////

    // create a FileReader object to read the JSON data from a file
    FileReader reader = new FileReader("C:\\Users\\maste\\Desktop\\JavaGameEngine\\src\\main\\java\\org\\ict\\Initialize.json");

    // create a JSONParser object to parse the JSON data
    JSONParser jsonParser = new JSONParser();

    // parse the JSON data into a JSONObject
    JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

    // access the values in the JSONObject
    long boardSize = (long) jsonObject.get("boardSize");
    long diceNum = (long) jsonObject.get("diceNum");
    long playerNum = (long) jsonObject.get("playerNum");
    String  difficulty= (String) jsonObject.get("difficulty");


    // print out the values
    /*System.out.println("boardSize: " + boardSize);
    System.out.println("diceNum: " + diceNum);
    System.out.println("playerNum: " + playerNum);
    System.out.println("difficulty: " + difficulty);
    */

    ///////////////end of parser//////////////////////

        public Main() throws IOException, ParseException {
        super("Snakes and Ladders");

        // set up the game board

        gameBoard = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < boardSize; i++) {
            JLabel label = new JLabel("" + (i+1), SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gameBoard.add(label);
        }
        getContentPane().add(gameBoard, BorderLayout.CENTER);

        // set up the game info panel
        gameInfo = new JTextArea();
        gameInfo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(gameInfo);
        getContentPane().add(scrollPane, BorderLayout.EAST);

        // set up the roll button

        rollButton = new JButton("Roll");
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long roll = diceNum*((long)(Math.random()*6) + 1);
                gameInfo.append("Player rolled a " + roll + "\n");
                playerPosition += roll;
                if (playerPosition > boardSize) {
                    playerPosition = boardSize - (playerPosition - boardSize);
                }
                gameInfo.append("Player moved to box " + playerPosition + "\n");
                checkForSnakesAndLadders((int) playerPosition);
                gameBoard.getComponent((int) (boardSize-playerPosition)).setBackground(Color.RED);
                if (playerPosition == boardSize) {
                    gameInfo.append("Player wins!\n");
                    rollButton.setEnabled(false);
                }
            }
        });
        getContentPane().add(rollButton, BorderLayout.SOUTH);
        // set up the player position
        playerPosition = 1;
        // set up the window
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void checkForSnakesAndLadders(int position) {
        switch (position) {
            case 4:
                playerPosition = 14;
                gameInfo.append("Player climbs a ladder to space 14\n");
                break;
            case 9:
                playerPosition = 31;
                gameInfo.append("Player climbs a ladder to space 31\n");
                break;
            case 17:
                playerPosition = 7;
                gameInfo.append("Player slides down a snake to space 7\n");
                break;
            case 20:
                playerPosition = 38;
                gameInfo.append("Player climbs a ladder to space 38\n");
                break;
            case 28:
                playerPosition = 84;
                gameInfo.append("Player climbs a ladder to space 84\n");
                break;
            case 40:
                playerPosition = 59;
                gameInfo.append("Player slides down a snake to space 59\n");
                break;
            case 51:
                playerPosition = 67;
                gameInfo.append("Player climbs a ladder to space 67\n");
                break;
            case 54:
                playerPosition = 34;
                gameInfo.append("Player slides down a snake to space 34\n");
                break;
            case 62:
                playerPosition = 19;
                gameInfo.append("Player slides down a snake to space 19\n");
                break;
            case 63:
                playerPosition = 81;
                gameInfo.append("Player climbs a ladder to space 81\n");
                break;
            case 64:
                playerPosition = 60;
                gameInfo.append("Player slides down a snake to space 60\n");
                break;
            case 71:
                playerPosition = 91;
                gameInfo.append("Player climbs a ladder to space 91\n");
                break;
            case 87:
                playerPosition = 24;
                gameInfo.append("Player slides down a snake to space 24\n");
                break;
            case 93:
                playerPosition = 73;
                gameInfo.append("Player slides down a snake to space 73\n");
                break;
            case 95:
                playerPosition = 75;
                gameInfo.append("Player slides down a snake to space 75\n");
                break;
            case 99:
                playerPosition = 78;
                gameInfo.append("Player slides down a snake to space 78\n");
                break;
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        new Main();
    }
}